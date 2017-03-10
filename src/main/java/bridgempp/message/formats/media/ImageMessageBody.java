package bridgempp.message.formats.media;

import java.io.IOException;
import java.net.URL;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ImageMessageBody")
@DiscriminatorValue(value = "ImageMessageBody")
public class ImageMessageBody extends MediaMessageBody
{
	@Column(name = "imageIdentifier", nullable = false, length = 4096)
	private String identifier;

	@Column(name = "mimeType", nullable = false)
	private MimeType mimeType;
	
	@Column(name = "url", nullable = false)
	private URL url;
	
	@Column(name = "caption", nullable = true, length = 4096)
	private String caption;
	
	

	public ImageMessageBody(String identifier, MimeType mimeType, URL url, String caption)
	{
		this.identifier = identifier;
		this.mimeType = mimeType;
		this.url = url;
		this.caption = caption;
	}
	

	public ImageMessageBody(String identifier, MimeType mimeType, URL url)
	{
		this(identifier, mimeType, url, "");
	}
	
	//JPA
	@SuppressWarnings("unused")
	private ImageMessageBody()
	{
	}


	@Override
	public String getIdentifier()
	{
		return identifier;
	}

	@Override
	public MimeType getMimeType()
	{
		return mimeType;
	}

	@Override
	public String getFormatName()
	{
		return "Image";
	}

	@Override
	public URL getURL()
	{
		return url;
	}

	/**
	 * @return the caption
	 */
	public String getCaption()
	{
		return caption;
	}

	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption)
	{
		this.caption = caption;
	}
	
	public boolean hasCaption()
	{
		return caption != null;
	}


	public static ImageMessageBody fromURL(URL imageURL) throws MimeTypeParseException, IOException
	{
		
		return new ImageMessageBody(imageURL.getHost(), new MimeType(imageURL.openConnection().getContentType()), imageURL);
	}

}
