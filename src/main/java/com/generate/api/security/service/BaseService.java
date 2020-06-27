package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

public interface BaseService<T,ID> {

	public T save(T t);
	
	public Optional<T> findById(ID id);
	
	public List<T> findAll();
	
	public T edit(T t);
	
	public void delete(T t);
	
	public void deleteById(ID id);
	
}
