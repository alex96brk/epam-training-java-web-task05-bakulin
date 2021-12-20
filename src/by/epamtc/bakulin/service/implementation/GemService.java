package by.epamtc.bakulin.service.implementation;

import java.util.List;

import by.epamtc.bakulin.dao.GemDAO;
import by.epamtc.bakulin.model.Gem;
import by.epamtc.bakulin.service.IGemService;

public class GemService implements IGemService {
	
	private GemDAO gemDao;
	
	public GemService(GemDAO gemDao) {
		this.gemDao = gemDao;
	}
	
	public GemService() {}
	
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
		return gemDao.findAll();
	}

	@Override
	public Gem update(Gem entity) {
		return null;
	}

	@Override
	public Gem delete(Long id) {
		return null;
	}
	
	public GemDAO getGemDao() {
		return gemDao;
	}

	public void setGemDao(GemDAO gemDao) {
		this.gemDao = gemDao;
	}

}
