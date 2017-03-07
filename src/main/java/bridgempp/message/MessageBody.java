package bridgempp.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity(name = "MessageBody")
public abstract class MessageBody
{
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@Column(name = "message", nullable = false)
	private Message message;
	
	public abstract String getFormatName();
	
	public String toString()
	{
		return getFormatName();
	}
	
	void setMessage(Message message)
	{
		this.message = message;
	}
	
}
