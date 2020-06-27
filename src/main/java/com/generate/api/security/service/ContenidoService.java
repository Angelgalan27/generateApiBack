package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.Contenido;

public interface ContenidoService {

	public Contenido save(Contenido t);
	
	public Optional<Contenido> findById(Long id);
	
	public List<Contenido> findAll();
	
	public Contenido edit(Contenido t);
	
	public void delete(Contenido t);
	
	public void deleteById(Long id);
}
