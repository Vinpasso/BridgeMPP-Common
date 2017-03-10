package bridgempp.message.formats.text;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "Base64EncodedMessageBody")
@DiscriminatorValue(value = "Base64EncodedMessageBody")
public class Base64EncodedMessageBody extends PlainTextMessageBody
{

	public Base64EncodedMessageBody(String text)
	{
		super(Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8)));
	}

	//JPA
	@SuppressWarnings("unused")
	private Base64EncodedMessageBody()
	{
	}
	
	public String getDecodedText()
	{
		return new String(Base64.getDecoder().decode(getText()), StandardCharsets.UTF_8);
	}

	
	@Override
	public String getFormatName()
	{
		return "Base64 Encoded";
	}
}
