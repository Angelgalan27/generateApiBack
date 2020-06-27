package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.TipoCampo;


public interface TipoCampoService {

	public TipoCampo save(TipoCampo t);
	
	public Optional<TipoCampo> findById(Long id);
	
	public List<TipoCampo> findAll();
	
	public TipoCampo edit(TipoCampo t);
	
	public void delete(TipoCampo t);
	
	public void deleteById(Long id);
}
