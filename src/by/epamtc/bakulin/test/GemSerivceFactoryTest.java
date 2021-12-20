package by.epamtc.bakulin.test;

import java.util.List;

import org.junit.Test;

import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.factory.GemServiceFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryEnum;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.provider.GemBuilderFactoryProvider;
import by.epamtc.bakulin.util.xml.exception.ParserNotFoundException;

public class GemSerivceFactoryTest {
	
	@Test
	public void test1() {
		GemBuilder gemBuilder = null;
		try {
			gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.GEM_DOM_PARSER).newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		} catch (ParserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		GemService gemService = GemServiceFactory.newService(gemBuilder);
		List<Gem> gemList = gemService.findAll();
		System.out.println(gemList);
	}
	
	@Test
	public void test2() {
		GemBuilder gemBuilder = null;
		try {
			gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.GEM_SAX_PARSER).newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		} catch (ParserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		GemService gemService = GemServiceFactory.newService(gemBuilder);
		List<Gem> gemList = gemService.findAll();
		System.out.println(gemList);
	}
	
	@Test
	public void test3() {
		GemBuilder gemBuilder = null;
		try {
			gemBuilder = GemBuilderFactoryProvider.getGemBuilderFactory(GemBuilderFactoryEnum.GEM_STAX_PARSER).newInstance();
			gemBuilder.buildGemSet("C:/Users/E-group/Desktop/epam/xml-task-resources/gems.xml");
		} catch (ParserNotFoundException e) {
			System.out.println(e.getMessage());
		}
		GemService gemService = GemServiceFactory.newService(gemBuilder);
		List<Gem> gemList = gemService.findAll();
		System.out.println(gemList);
	}
}
