package bridgempp.message.formats.text;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jsoup.nodes.Document.OutputSettings.Syntax;

@Entity(name = "XHTMLMessageBody")
@DiscriminatorValue(value = "XHTMLMessageBody")
public class XHTMLMessageBody extends HTMLMessageBody
{

	public XHTMLMessageBody(String htmlText)
	{
		super(htmlText);
		htmlDocument.outputSettings().syntax(Syntax.xml);
	}

	//JPA
	protected XHTMLMessageBody()
	{
	}

	@Override
	public String getFormatName()
	{
		return "XHTML";
	}
	
}
