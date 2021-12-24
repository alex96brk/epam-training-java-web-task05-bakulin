package by.epamtc.bakulin.util.xml.document.gem.builder;

import java.util.HashSet;
import java.util.Set;

import by.epamtc.bakulin.model.Gem;

public abstract class GemBuilder {
	
	private Set<Gem> gems;
	
	public GemBuilder() {
		this.gems = new HashSet<Gem>();
	}
	
	public Set<Gem> getGems() {
		return gems;
	}
	
	public abstract void buildGemSet(String xmlPath);
}
