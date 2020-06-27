package com.generate.api.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.Contenido;
import com.generate.api.security.repository.ContenidoRepository;
import com.generate.api.security.service.ContenidoService;

@Service
public class ContenidoServiceImpl 
			extends BaseServiceImpl<Contenido, Long, ContenidoRepository> 
					implements ContenidoService {

}
