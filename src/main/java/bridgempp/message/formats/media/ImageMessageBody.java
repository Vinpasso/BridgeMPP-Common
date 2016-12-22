package bridgempp.message.formats.media;

import java.io.IOException;
import java.net.URL;
import javax.activation.MimeType;
import javax.activation.MimeTypeParseException;

public class ImageMessageBody extends MediaMessageBody
{
	private String identifier;
	private MimeType mimeType;
	private URL url;
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
