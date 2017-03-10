package bridgempp.message.formats.media;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;
import java.util.logging.Level;

import javax.activation.MimeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.apache.commons.io.IOUtils;

import bridgempp.log.Log;
import bridgempp.message.MessageBody;

@Entity(name = "MediaMessageBody")
@DiscriminatorValue(value = "MediaMessageBody")
public abstract class MediaMessageBody extends MessageBody
{
	public abstract String getIdentifier();
	public abstract URL getURL();
	public abstract MimeType getMimeType();
	
	private byte[] data;
	
	public byte[] getData()
	{
		if(data != null)
		{
			return data;
		}
		try
		{
			data = IOUtils.toByteArray(getURL());
		} catch (IOException e)
		{
			Log.log(Level.WARNING, "Could not fetch media from URL", e);
		}
		return data;
	}
	
	public String getDataAsBase64() throws IOException
	{
		return Base64.getEncoder().encodeToString(getData());
	}

	
}
