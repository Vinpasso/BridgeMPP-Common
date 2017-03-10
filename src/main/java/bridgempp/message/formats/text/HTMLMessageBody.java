package bridgempp.message.formats.text;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import org.jsoup.Jsoup;
import org.jsoup.examples.HtmlToPlainText;
import org.jsoup.nodes.Document;

@Entity(name = "HTMLMessageBody")
@DiscriminatorValue(value = "HTMLMessageBody")
public class HTMLMessageBody extends MarkupTextMessageBody
{
	protected transient Document htmlDocument;

	@Column(name = "htmlCode", nullable = false, length = 21844)
	private String htmlText = "";
	
	public HTMLMessageBody(String htmlText)
	{
		super();
		htmlDocument = Jsoup.parse(htmlText);
		this.htmlText = htmlText;
	}
	
	//JPA
	protected HTMLMessageBody()
	{
		super();
		htmlDocument = Jsoup.parse(htmlText);
	}
	
	@Override
	public String getText()
	{
		return htmlDocument.outerHtml();
	}

	@Override
	public String getFormatName()
	{
		return "HTML";
	}

	private static HtmlToPlainText converter = new HtmlToPlainText();
	
	public String formatToPlainText()
	{
		return converter.getPlainText(htmlDocument);
	}

}
