package by.epamtc.bakulin.dao;

import java.util.List;

public interface DAO <T, ID> {
	
	boolean add(T value);
	
	T findById(ID id);
	
	List<T> findAll();
	
	T update(T entity);
	
	T delete(ID id);
	
}
