package com.generate.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generate.api.security.model.ValorCampoContenido;
import com.generate.api.security.service.ValorCampoContenidoService;

@RestController
@RequestMapping("/valorcampocontenido")
public class ValorCampoContenidoController {

	@Autowired
	private ValorCampoContenidoService valorCampoContenidoService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<ValorCampoContenido> getAll(){
		return valorCampoContenidoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public ValorCampoContenido get(@PathVariable Long id) {
		return valorCampoContenidoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public ValorCampoContenido save(@RequestBody ValorCampoContenido valorCampoContenido) {
		return valorCampoContenidoService.save(valorCampoContenido);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public ValorCampoContenido update(@RequestBody ValorCampoContenido valorCampoContenido) {
		return valorCampoContenidoService.save(valorCampoContenido);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		valorCampoContenidoService.deleteById(id);
	}
}
