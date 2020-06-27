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

import com.generate.api.security.model.TipoContenido;
import com.generate.api.security.service.TipoContenidoService;

@RestController
@RequestMapping("/tipoContenido")
public class TipoContenidoController {

	@Autowired
	private TipoContenidoService tipoContenidoService;
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<TipoContenido> getAll(){
		return tipoContenidoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public TipoContenido get(@PathVariable Long id) {
		return tipoContenidoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public TipoContenido save(@RequestBody TipoContenido tipoCampo) {
		return tipoContenidoService.save(tipoCampo);
	}
	
	@RequestMapping(method = RequestMethod.PUT,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public TipoContenido update(@RequestBody TipoContenido tipoCampo) {
		return tipoContenidoService.save(tipoCampo);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		tipoContenidoService.deleteById(id);
	}
}
