package bridgempp.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity(name = "MessageBody")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class MessageBody
{
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	
	@ManyToOne(optional=false)
	@JoinColumn(name = "message_id", referencedColumnName = "id")
	private Message message;
	
	@Version
	@Column(name = "VERSION", nullable = false)
	private long version;

	
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
