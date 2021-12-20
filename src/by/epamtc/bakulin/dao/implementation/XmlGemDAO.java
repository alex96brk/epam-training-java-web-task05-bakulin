package by.epamtc.bakulin.dao.implementation;

import java.util.ArrayList;
import java.util.List;

import by.epamtc.bakulin.dao.GemDAO;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.util.xml.document.gem.builder.GemBuilder;

public class XmlGemDAO implements GemDAO {
	
	private GemBuilder abstractGemBuilder;
	
	public XmlGemDAO(GemBuilder abstractGemBuilder) {
		this.abstractGemBuilder = abstractGemBuilder;
	}

	@Override
	public boolean add(Gem value) {
		return false;
	}

	@Override
	public Gem findById(Long id) {
		return null;
	}

	@Override
	public List<Gem> findAll() {
		return new ArrayList<Gem>(abstractGemBuilder.getGems());
	}

	@Override
	public Gem update(Gem entity) {
		return null;
	}

	@Override
	public Gem delete(Long id) {
		return null;
	}
	
}
