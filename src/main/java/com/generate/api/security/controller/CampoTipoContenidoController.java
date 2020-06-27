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

import com.generate.api.security.model.CamposTipoContenido;
import com.generate.api.security.service.CampoTipoContenidoService;

@RestController
@RequestMapping("/campostipocontenido")
public class CampoTipoContenidoController {

	@Autowired
	private CampoTipoContenidoService campoTipoContenidoService;
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<CamposTipoContenido> getAll(){
		return campoTipoContenidoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public CamposTipoContenido get(@PathVariable Long id) {
		return campoTipoContenidoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public CamposTipoContenido save(@RequestBody CamposTipoContenido campoTipoContenido) {
		return campoTipoContenidoService.save(campoTipoContenido);
	}
	
	@RequestMapping(method = RequestMethod.PUT,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public CamposTipoContenido update(@RequestBody CamposTipoContenido campoTipoContenido) {
		return campoTipoContenidoService.save(campoTipoContenido);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		campoTipoContenidoService.deleteById(id);
	}
}
