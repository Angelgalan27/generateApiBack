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

import com.generate.api.security.model.TipoCampo;
import com.generate.api.security.service.TipoCampoService;

@RestController
@RequestMapping("/tipoCampo")
public class TipoCampoController {

	
	@Autowired
	private TipoCampoService tipoCampoService;
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<TipoCampo> getAll(){
		return tipoCampoService.findAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public TipoCampo get(@PathVariable Long id) {
		return tipoCampoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public TipoCampo save(@RequestBody TipoCampo tipoCampo) {
		return tipoCampoService.save(tipoCampo);
	}
	
	@RequestMapping(method = RequestMethod.PUT,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public TipoCampo update(@RequestBody TipoCampo tipoCampo) {
		return tipoCampoService.save(tipoCampo);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		 tipoCampoService.deleteById(id);
	}
	
	
}
