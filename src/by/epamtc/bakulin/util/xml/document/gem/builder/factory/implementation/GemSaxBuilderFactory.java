package by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation;

import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.implementation.GemSaxBuilder;

public class GemSaxBuilderFactory implements GemBuilderFactory {
	
	private final GemSaxBuilder gemSaxBuilderInstance;
	
	public GemSaxBuilderFactory() {
		this.gemSaxBuilderInstance = new GemSaxBuilder();
	}
	
	@Override
	public GemBuilder newInstance() {
		return gemSaxBuilderInstance;
	}

}
