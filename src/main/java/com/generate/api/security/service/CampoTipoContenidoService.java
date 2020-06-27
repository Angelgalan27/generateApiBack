package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.CamposTipoContenido;

public interface CampoTipoContenidoService {

	public CamposTipoContenido save(CamposTipoContenido t);
	
	public Optional<CamposTipoContenido> findById(Long id);
	
	public List<CamposTipoContenido> findAll();
	
	public CamposTipoContenido edit(CamposTipoContenido t);
	
	public void delete(CamposTipoContenido t);
	
	public void deleteById(Long id);
}
