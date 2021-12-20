package by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation;

import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.implementation.GemStaxBuilder;

public class GemStaxBuilderFactory implements GemBuilderFactory {
	
	private GemStaxBuilder gemStaxBuilderInstance;
	
	public GemStaxBuilderFactory() {
		this.gemStaxBuilderInstance = new GemStaxBuilder();
	}
	
	@Override
	public GemBuilder newInstance() {
		return gemStaxBuilderInstance;
	}

}
