package com.generate.api.security.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.Evento;
import com.generate.api.security.repository.EventoRepository;
import com.generate.api.security.service.EventoService;

@Service
public class EventoServiceImpl extends BaseServiceImpl<Evento, Long, EventoRepository> 
										implements EventoService {

	@Override
	public List<Evento> findAllPagination(Long limit, Long until) {
		return repositorio.findAll(Integer.valueOf(limit.toString()),Integer.valueOf(until.toString()));
	}

	@Override
	public Long getTotalEvents() {
		return repositorio.getTotalPost();
	}

}
