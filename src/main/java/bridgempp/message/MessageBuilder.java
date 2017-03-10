package bridgempp.message;

import java.util.List;

import bridgempp.data.Endpoint;
import bridgempp.data.Group;
import bridgempp.data.User;
import bridgempp.message.formats.text.PlainTextMessageBody;

public class MessageBuilder
{
	private Message message;
	
	public MessageBuilder(User sender, Endpoint origin)
	{
		message = new Message(sender, origin);
	}
	
	
	/**
	 * This WILL prepend Author
	 * @param body
	 * @return builder
	 */
	public MessageBuilder addPlainTextBody(String body)
	{
		message.addMessageBody(new PlainTextMessageBody(((message.getSender()==null)?"BridgeMPP":message.getSender().toString()) + ": " + body));
		return this;
	}
	
	public Message build()
	{
		return message;
	}


	public MessageBuilder addMessageBody(MessageBody messageBody)
	{
		message.addMessageBody(messageBody);
		return this;
	}
	
	public MessageBuilder addMessageDestination(Endpoint destination)
	{
		message.addDestinationEndpoint(destination);
		return this;
	}
	
	public MessageBuilder addDestinationsFromGroupNoLoopback(Group... groups)
	{
		message.addDestinationsFromGroupNoLoopback(groups);
		return this;
	}


	public MessageBuilder addDestinationsFromGroupNoLoopback(List<Group> groups)
	{
		groups.forEach(g -> message.addDestinationsFromGroupNoLoopback(g));
		return this;
	}
}
