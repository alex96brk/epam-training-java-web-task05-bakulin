package by.epamtc.bakulin.service;

import java.util.List;

import by.epamtc.bakulin.model.Gem;

public interface IGemService {
	
	boolean add(Gem value);
	
	Gem findById(Long id);
	
	List<Gem> findAll();
	
	Gem update(Gem entity);
	
	Gem delete(Long id);
}
