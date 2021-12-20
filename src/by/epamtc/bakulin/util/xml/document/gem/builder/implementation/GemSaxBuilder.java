package by.epamtc.bakulin.util.xml.document.gem.builder.implementation;

import java.io.IOException;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.handler.GemSaxHandler;
import by.epamtc.bakulin.util.xml.exception.handler.SaxExceptionHandler;

public class GemSaxBuilder extends GemBuilder {

	private Set<Gem> gems;

	private GemSaxHandler gemHandler;

	private XMLReader xmlReader;

	private SaxExceptionHandler saxExceptionHandler;

	{
		this.saxExceptionHandler = new SaxExceptionHandler();
	}

	public GemSaxBuilder() {
		this.gemHandler = new GemSaxHandler();

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = saxParserFactory.newSAXParser();
			xmlReader = saxParser.getXMLReader();
		} catch (ParserConfigurationException exception) {
			saxExceptionHandler.error(exception);
		} catch (SAXException exception) {
			saxExceptionHandler.error(exception);
		}
		xmlReader.setErrorHandler(new GemSaxHandler());
		xmlReader.setContentHandler(gemHandler);
	}

	public Set<Gem> getGems() {
		return gems;
	}

	@Override
	public void buildGemSet(String filePath) {
		try {
			xmlReader.parse(filePath);
		} catch (IOException exception) {
			saxExceptionHandler.error(exception);
		} catch (SAXException exception) {
			saxExceptionHandler.error(exception);
		}
		gems = gemHandler.getGems();
	}
}
