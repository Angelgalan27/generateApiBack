package com.generate.api.security.service;

import java.util.List;
import java.util.Optional;

import com.generate.api.security.model.Evento;

public interface EventoService {


	public Evento save(Evento t);
	
	public Optional<Evento> findById(Long id);
	
	public List<Evento> findAll();
	
	public List<Evento> findAllPagination(Long limit, Long until);
	
	public Evento edit(Evento t);
	
	public void delete(Evento t);
	
	public void deleteById(Long id);
	
	public Long getTotalEvents();
}
