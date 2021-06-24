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

import com.generate.api.security.model.Categoria;
import com.generate.api.security.service.CategoriaService;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<Categoria> getAll(){
		return categoriaService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Categoria get(@PathVariable Long id) {
		return categoriaService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST ,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Categoria save(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Categoria update(@RequestBody Categoria categoria) {
		return categoriaService.save(categoria);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		categoriaService.deleteById(id);
	}
}
