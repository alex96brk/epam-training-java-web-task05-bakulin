package by.epamtc.bakulin.test;

import java.util.Set;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemDomBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemSaxBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation.GemStaxBuilderFactory;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GemXmlBuilderFactoryTest {

	@Test
	public void testDomBuilder() {
		GemBuilderFactory gemBuilderFactory = new GemDomBuilderFactory();
		GemBuilder gemBuilder = gemBuilderFactory.newInstance();
		gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		Set<Gem> gemSet = gemBuilder.getGems();
		System.out.println("DOM: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
	}

	@Test
	public void testSaxBuilder() {
		GemBuilderFactory gemBuilderFactory = new GemSaxBuilderFactory();
		GemBuilder gemBuilder = gemBuilderFactory.newInstance();
		gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		Set<Gem> gemSet = gemBuilder.getGems();
		System.out.println("SAX: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
	}
	
	@Test
	public void testStaxBuilder() {
		GemBuilderFactory gemBuilderFactory = new GemStaxBuilderFactory();
		GemBuilder gemBuilder = gemBuilderFactory.newInstance();
		gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		Set<Gem> gemSet = gemBuilder.getGems();
		System.out.println("StAX: " + gemSet + "\n" + gemBuilder.getClass() + "\n");
	}
}
