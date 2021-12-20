package by.epamtc.bakulin.util.xml.document.gem.builder.factory.implementation;

import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;
import by.epamtc.bakulin.util.xml.document.gem.builder.factory.GemBuilderFactory;
import by.epamtc.bakulin.util.xml.document.gem.builder.implementation.GemDomBuilder;

public class GemDomBuilderFactory implements GemBuilderFactory {
	
	private final GemDomBuilder gemDomBuilderInstance;
	
	public GemDomBuilderFactory() {
		this.gemDomBuilderInstance = new GemDomBuilder(); 
	}
	
	@Override
	public GemBuilder newInstance() {
		return gemDomBuilderInstance;
	}
	
}
