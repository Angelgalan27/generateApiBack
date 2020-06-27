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

import com.generate.api.security.model.Contenido;
import com.generate.api.security.service.ContenidoService;

@RestController
@RequestMapping("/contenido")
public class ContenidoController {

	@Autowired
	private ContenidoService contenidoService;
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<Contenido> getAll(){
		return contenidoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Contenido get(@PathVariable Long id) {
		return contenidoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST ,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Contenido save(@RequestBody Contenido contenido) {
		return contenidoService.save(contenido);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Contenido update(@RequestBody Contenido contenido) {
		return contenidoService.save(contenido);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		contenidoService.deleteById(id);
	}
}
