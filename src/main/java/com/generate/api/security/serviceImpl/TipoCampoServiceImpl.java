package com.generate.api.security.serviceImpl;

import org.springframework.stereotype.Service;

import com.generate.api.security.model.TipoCampo;
import com.generate.api.security.repository.TipoCampoRepository;
import com.generate.api.security.service.TipoCampoService;

@Service
public class TipoCampoServiceImpl extends BaseServiceImpl<TipoCampo, Long, TipoCampoRepository> implements TipoCampoService{

}
