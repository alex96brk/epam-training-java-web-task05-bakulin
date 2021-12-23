package by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider;

import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemDomBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemSaxBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemStaxBuilderFactory;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;

public class GemBuilderFactoryProvider {
	
	public static GemBuilderFactory getGemBuilderFactory(GemBuilderFactoryEnum xmlParserType) throws ParserNotFoundException {
		return getGemBuilderFactory(xmlParserType.name());
	}

	public static GemBuilderFactory getGemBuilderFactory(String xmlParserType) throws ParserNotFoundException {
		GemBuilderFactory gemBuilderFactory = null;
		boolean isDom = xmlParserType.equalsIgnoreCase(GemBuilderFactoryEnum.DOM.name());
		boolean isSax = xmlParserType.equalsIgnoreCase(GemBuilderFactoryEnum.SAX.name());
		boolean isStax = xmlParserType.equalsIgnoreCase(GemBuilderFactoryEnum.StAX.name());
		if (isDom) {
			gemBuilderFactory = new GemDomBuilderFactory();
		}
		if (isSax) {
			gemBuilderFactory = new GemSaxBuilderFactory();
		}
		if (isStax) {
			gemBuilderFactory = new GemStaxBuilderFactory();
		}
		if ((isDom == false) && (isSax == false) && (isStax == false)) {
			throw new ParserNotFoundException("Parser not found. ParserID = " + xmlParserType);
		}
		return gemBuilderFactory;
	}
}
