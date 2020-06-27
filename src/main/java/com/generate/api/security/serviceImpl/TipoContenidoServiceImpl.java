package com.generate.api.security.serviceImpl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.generate.api.security.model.TipoContenido;
import com.generate.api.security.service.TipoContenidoService;

@Service
public class TipoContenidoServiceImpl 
		extends BaseServiceImpl<TipoContenido, Long, JpaRepository<TipoContenido,Long>> 
			implements TipoContenidoService {

}
