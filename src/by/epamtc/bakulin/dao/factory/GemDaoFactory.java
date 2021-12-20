package by.epamtc.bakulin.dao.factory;

import by.epamtc.bakulin.dao.GemDAO;
import by.epamtc.bakulin.dao.implementation.XmlGemDAO;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;

public class GemDaoFactory {

	public static GemDAO newInstance(GemBuilder gemBuilder) {
		return new XmlGemDAO(gemBuilder);
	}

}
