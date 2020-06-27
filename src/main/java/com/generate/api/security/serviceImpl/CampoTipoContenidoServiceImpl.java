package com.generate.api.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.CamposTipoContenido;
import com.generate.api.security.repository.CamposTipoContenidoRepository;
import com.generate.api.security.service.CampoTipoContenidoService;

@Service
public class CampoTipoContenidoServiceImpl 
			extends BaseServiceImpl<CamposTipoContenido, Long, CamposTipoContenidoRepository> 
					implements CampoTipoContenidoService {

}
