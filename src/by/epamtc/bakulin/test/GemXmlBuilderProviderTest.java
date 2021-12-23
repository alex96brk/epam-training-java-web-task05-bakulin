package by.epamtc.bakulin.test;

import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryEnum;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;
import by.epamtc.bakulin.util.xml.exception.handler.SaxExceptionHandler;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GemXmlBuilderProviderTest {
	
	private SaxExceptionHandler saxExceptionHandler = new SaxExceptionHandler();
	
	
	public void gemDomProviderTest() {
		try {
			GemBuilderFactory gemBuilderFactory = GemBuilderFactoryProvider.getGemBuilderFactory("gem_dom_parser");
			GemBuilder gemBuilder = gemBuilderFactory.newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			Set<Gem> gemSet = gemBuilder.getGems();
			System.out.println("DOM: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
			
		} catch (ParserNotFoundException e) {
			saxExceptionHandler.error(e);
		}
	}

	
	public void gemSaxProviderTest() {
		try {
			GemBuilderFactory gemBuilderFactory = GemBuilderFactoryProvider.getGemBuilderFactory("gem_sax_parser");
			GemBuilder gemBuilder = gemBuilderFactory.newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			Set<Gem> gemSet = gemBuilder.getGems();
			System.out.println("SAX: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
			
		} catch (ParserNotFoundException e) {
			saxExceptionHandler.error(e);
		}
	}

	@Test
	public void gemStaxProviderTest() {
		try {
			GemBuilderFactory gemBuilderFactory = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.StAX);
			GemBuilder gemBuilder = gemBuilderFactory.newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			Set<Gem> gemSet = gemBuilder.getGems();
			System.out.println("StAX: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
			
		} catch (ParserNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public void gemZIllegalProviderTest() {
		try {
			GemBuilderFactory gemBuilderFactory = GemBuilderFactoryProvider.getGemBuilderFactory("gem_privet_parser");
			GemBuilder gemBuilder = gemBuilderFactory.newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
			Set<Gem> gemSet = gemBuilder.getGems();
			System.out.println("StAX: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
			
		} catch (ParserNotFoundException e) {
			saxExceptionHandler.error(e);
		}
	}
}
