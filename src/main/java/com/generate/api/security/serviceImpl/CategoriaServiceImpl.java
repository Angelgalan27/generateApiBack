package com.generate.api.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.Categoria;
import com.generate.api.security.repository.CategoriaRepository;
import com.generate.api.security.service.CategoriaService;

@Service
public class CategoriaServiceImpl 
		extends BaseServiceImpl<Categoria, Long, CategoriaRepository> 
				implements CategoriaService{

}
