package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.ValorCampoContenido;

public interface ValorCampoContenidoService {

	public ValorCampoContenido save(ValorCampoContenido t);
	
	public Optional<ValorCampoContenido> findById(Long id);
	
	public List<ValorCampoContenido> findAll();
	
	public ValorCampoContenido edit(ValorCampoContenido t);
	
	public void delete(ValorCampoContenido t);
	
	public void deleteById(Long id);
}
