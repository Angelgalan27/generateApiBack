package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.TipoContenido;

public interface TipoContenidoService {

	public TipoContenido save(TipoContenido t);
	
	public Optional<TipoContenido> findById(Long id);
	
	public List<TipoContenido> findAll();
	
	public TipoContenido edit(TipoContenido t);
	
	public void delete(TipoContenido t);
	
	public void deleteById(Long id);
}
