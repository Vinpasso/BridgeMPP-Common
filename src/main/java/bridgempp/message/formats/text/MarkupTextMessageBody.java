package bridgempp.message.formats.text;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import bridgempp.message.MessageBody;

@Entity(name = "MarkupTextMessageBody")
@DiscriminatorValue(value = "MarkupTextMessageBody")
public abstract class MarkupTextMessageBody extends MessageBody
{
	
	public MarkupTextMessageBody()
	{
		super();
	}

	public abstract String getText();
	
}
