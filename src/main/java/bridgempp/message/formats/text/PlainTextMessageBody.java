package bridgempp.message.formats.text;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import bridgempp.message.MessageBody;

@Entity(name = "PlainTextMessageBody")
@DiscriminatorValue(value = "PlainTextMessageBody")
public class PlainTextMessageBody extends MessageBody
{
	@Column(name = "text", nullable = false, length=21844)
	private String text;
	
	public PlainTextMessageBody(String text)
	{
		this.text = (text == null) ? "" : text;
	}
	
	//JPA
	protected PlainTextMessageBody()
	{
	}
	
	@Override
	public String getFormatName()
	{
		return "Plain Text";
	}

	/**
	 * @return the text
	 */
	public String getText()
	{
		return text;
	}
	
	public String toString()
	{
		return getText();
	}

}
