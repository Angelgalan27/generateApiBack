package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.Categoria;

public interface CategoriaService {

	public Categoria save(Categoria t);
	
	public Optional<Categoria> findById(Long id);
	
	public List<Categoria> findAll();
	
	public Categoria edit(Categoria t);
	
	public void delete(Categoria t);
	
	public void deleteById(Long id);
}
