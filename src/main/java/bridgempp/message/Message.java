/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bridgempp.message;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import bridgempp.data.DataManager;
import bridgempp.data.Endpoint;
import bridgempp.data.Group;
import bridgempp.data.User;
import bridgempp.data.processing.Schedule;
import bridgempp.log.Log;
import bridgempp.message.formats.media.MediaMessageBody;
import bridgempp.message.formats.text.MarkupTextMessageBody;
import bridgempp.message.formats.text.PlainTextMessageBody;
import bridgempp.state.Event;
import bridgempp.state.EventManager;

/**
 *
 * @author Vincent Bode
 */
@Entity(name = "Message")
public class Message
{
	@Id()
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "id", nullable = false) 
	private int id;
	
	@Column(name = "Sender", nullable = false)
	private User sender;

	@Column(name = "Origin", nullable = false)
	private Endpoint origin;

	@OneToMany(mappedBy = "Message", cascade = CascadeType.ALL)
	private List<DeliveryGoal> destinations;
	
	@Column(name = "Last_Delivery_Attempt", nullable = false)
	private Date lastDeliveryAttempt;
	
	@Column(name = "Next_Delivery_Delay", nullable = false)
	private long nextDeliveryDelay = 5000l;

	@ManyToMany()
	@JoinTable(name = "MESSAGE_GROUPS", joinColumns = @JoinColumn(name = "id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "CHANNEL_NAME", referencedColumnName = "CHANNEL_NAME"))
	private List<Group> groups;

	//TODO: Declare this Map properly
	@MapKeyColumn(name = "MessageType")
	@OneToMany(mappedBy = "Message", cascade = CascadeType.ALL)
	private Map<Class<? extends MessageBody>, MessageBody> messageBodies;

	@Column(name = "OriginalMessageBody", nullable = false)
	private MessageBody originalMessageBody;

	public Message()
	{
		this(null, null);
	}

	public Message(User sender, Endpoint origin)
	{
		this.sender = sender;
		this.origin = origin;
		this.destinations = new ArrayList<>();
		this.groups = new ArrayList<>();
		this.messageBodies = new HashMap<>();
	}

	/**
	 * @return the sender
	 */
	public User getSender()
	{
		return sender;
	}

	/**
	 * @param sender
	 *            the sender to set
	 */
	public void setSender(User sender)
	{
		this.sender = sender;
	}

	/**
	 * @return the Origin
	 */
	public Endpoint getOrigin()
	{
		return origin;
	}

	/**
	 * @param sender
	 *            the Origin to set
	 */
	public void setOrigin(Endpoint sender)
	{
		this.origin = sender;
	}

	public void addDestinationEndpoint(Endpoint endpoint)
	{
		destinations.add(new DeliveryGoal(this, endpoint));
	}

	private List<DeliveryGoal> getDeliveryGoals()
	{
		return destinations;
	}

	public String getMetadataInfo()
	{
		String messageFormat = (messageBodies.isEmpty() ? "Empty" : originalMessageBody.getFormatName()) + ": ";
		String sender = (getSender() != null) ? getSender().toString() : "Unknown";
		String origin = (getOrigin() != null) ? getOrigin().toString() : "Unknown";
		String target = getDeliveryGoals().stream().filter(e -> e.getStatus().equals(DeliveryStatus.DELIVERED)).count() + "/" + getDeliveryGoals().size();
		return messageFormat + sender + " (" + origin + "): " + target + " delivered.";
	}

	@Override
	public String toString()
	{
		return getMetadataInfo();
	}

	public void addMessageBody(MessageBody messageBody)
	{
		messageBody.setMessage(this);
		messageBodies.put(messageBody.getClass(), messageBody);
		if (originalMessageBody == null)
		{
			originalMessageBody = messageBody;
		}
	}

	@SuppressWarnings("unchecked")
	public <T extends MessageBody> T getMessageBody(Class<T> messageBodyClass)
	{
		MessageBody messageBody = messageBodies.get(messageBodyClass);
		if (messageBody != null)
		{
			return (T) messageBody;
		}

		T convertedMessageBody = MessageBodyRegister.convert(originalMessageBody, messageBodyClass);
		if (convertedMessageBody != null)
		{
			messageBodies.put(messageBodyClass, convertedMessageBody);
			return convertedMessageBody;
		}
		return null;
	}

	public String getPlainTextMessageBody()
	{
		String result = getMessageBody(PlainTextMessageBody.class).getText();
		return (result != null) ? result : "";
	}

	/**
	 * Includes conversions
	 * 
	 * @param bodyClass
	 *            The target body class
	 * @return Whether the message is available or can be converted
	 */
	public boolean hasMessageBody(Class<? extends MessageBody> bodyClass)
	{
		return messageBodies.containsKey(bodyClass) || MessageBodyRegister.canConvert(originalMessageBody, bodyClass);
	}

	private MessageBody getOriginalMessageBody()
	{
		return originalMessageBody;
	}

	public boolean hasOriginalMessageBody(Class<? extends MessageBody> bodyClass)
	{
		return bodyClass.isAssignableFrom(getOriginalMessageBody().getClass());
	}

	public boolean isPlainTextMessage()
	{
		return originalMessageBody instanceof PlainTextMessageBody;
	}

	public boolean isMarkupTextMessage()
	{
		return originalMessageBody instanceof MarkupTextMessageBody;
	}

	public boolean isMediaMessage()
	{
		return originalMessageBody instanceof MediaMessageBody;
	}

	public boolean isTextMessage()
	{
		return isPlainTextMessage() || isMarkupTextMessage();
	}

	public void send()
	{
		EventManager.fireEvent(Event.MESSAGE, this);
	}

	public void addDestinationsFromGroupNoLoopback(Group... groups2)
	{
		Arrays.stream(groups2).forEach(group -> {
			group.getEndpoints().stream().filter(e -> !e.equals(getOrigin())).forEach(e -> addDestinationEndpoint(e));
			groups.add(group);
		});
	}

	public List<Group> getGroups()
	{
		return groups;
	}

	public List<DeliveryGoal> getDestinations()
	{
		return destinations;
	}

	public Collection<MessageBody> getMessageBodies()
	{
		return messageBodies.values();
	}

	public void deliver()
	{
		if(checkAllDelivered())
		{
			return;
		}
		
		DataManager.updateState(this);
		getDeliveryGoals().stream().filter(e -> e.getStatus() != DeliveryStatus.DELIVERED).forEach(e -> {
			try
			{
				e.getTarget().sendMessage(this, e);
			} catch (Exception ex)
			{
				Log.log(Level.WARNING, "Delivery failed to endpoint " + e.toString(), ex);
			}
		});
		if(!checkAllDelivered())
		{
			updateDeliveryTimestamps();
			scheduleNextDelivery();
		}
	}
	
	public boolean checkAllDelivered()
	{
		if(getDeliveryGoals().stream().allMatch(e -> e.getStatus() == DeliveryStatus.DELIVERED))
		{
			DataManager.removeState(this);
			return true;
		}
		return false;
	}

	public int getLength()
	{
		return getPlainTextMessageBody().length();
	}
	
	public MessageBuilder constructReply(User sender, Endpoint origin)
	{
		return new MessageBuilder(sender, origin)
				.addDestinationsFromGroupNoLoopback(getGroups());
	}
	
	public Message directConstructReply(User sender, Endpoint origin, String plainTextMessageBody)
	{
		return constructReply(sender, origin).addPlainTextBody(plainTextMessageBody).build();
	}
	
	public void updateDeliveryTimestamps()
	{
		lastDeliveryAttempt = Date.from(Instant.now());
		//Double the delay to the maximum of one hour delay
		nextDeliveryDelay = Math.min(3600000l, nextDeliveryDelay * 2);
	}
	
	public void scheduleNextDelivery()
	{
		Schedule.scheduleOnce(() -> this.deliver(), Math.max(0, (lastDeliveryAttempt.getTime() + nextDeliveryDelay) - System.currentTimeMillis()), TimeUnit.MILLISECONDS);
	}
	
}
