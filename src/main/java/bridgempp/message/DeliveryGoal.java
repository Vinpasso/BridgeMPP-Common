package bridgempp.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import bridgempp.data.DataManager;
import bridgempp.data.Endpoint;

@Entity(name = "DeliveryGoal")
public class DeliveryGoal
{
	@Id()
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Identifier", nullable = false)
	private int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "endpoint_id", referencedColumnName = "IDENTIFIER")
	private Endpoint target;

	@ManyToOne(optional=false)
	@JoinColumn(name = "message_id", referencedColumnName = "id")
	private Message message;
	
	@Column(name = "DeliveryStatus", nullable = false)
	private DeliveryStatus status;
	
	@Version
	@Column(name = "VERSION", nullable = false)
	private long version;


	
	public DeliveryGoal(Message message, Endpoint endpoint)
	{
		target = endpoint;
		status = DeliveryStatus.PENDING;
		this.message = message;
	}
	
	// JPA
	@SuppressWarnings("unused")
	private DeliveryGoal()
	{
		
	}
	
	
	public String toString()
	{
		return target.toString() + " (" + status.toString() + ")"; 
	}


	/**
	 * @return the status
	 */
	public DeliveryStatus getStatus()
	{
		return status;
	}


	/**
	 * @param status the status to set
	 */
	public void setStatus(DeliveryStatus status)
	{
		this.status = status;
		DataManager.updateState(this);
	}


	/**
	 * @return the target
	 */
	public Endpoint getTarget()
	{
		return target;
	}


	public void setDelivered()
	{
		setStatus(DeliveryStatus.DELIVERED);
	}
}
