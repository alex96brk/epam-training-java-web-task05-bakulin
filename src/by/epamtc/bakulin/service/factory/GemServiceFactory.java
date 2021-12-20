package by.epamtc.bakulin.service.factory;

import by.epamtc.bakulin.dao.factory.GemDaoFactory;
import by.epamtc.bakulin.service.implementation.GemService;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;


public class GemServiceFactory {
	
	public static GemService newService(GemBuilder gemBuilder) {
		return new GemService(GemDaoFactory.newInstance(gemBuilder));
	}
}
