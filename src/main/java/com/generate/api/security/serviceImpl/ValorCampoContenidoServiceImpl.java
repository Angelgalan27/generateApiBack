package com.generate.api.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.ValorCampoContenido;
import com.generate.api.security.repository.ValorCampoContenidoRepository;
import com.generate.api.security.service.ValorCampoContenidoService;

@Service
public class ValorCampoContenidoServiceImpl 
			extends BaseServiceImpl<ValorCampoContenido, Long, ValorCampoContenidoRepository>
					implements ValorCampoContenidoService{

}
