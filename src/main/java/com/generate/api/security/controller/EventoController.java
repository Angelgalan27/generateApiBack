package com.generate.api.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.generate.api.bean.EventPagination;
import com.generate.api.bean.PostPagination;
import com.generate.api.security.model.Evento;
import com.generate.api.security.service.EventoService;

@RestController
@RequestMapping("/evento")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;
	
	
	@RequestMapping(method = RequestMethod.GET,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public List<Evento> getAll() {
		return eventoService.findAll();
		
	}
	
	@PostMapping("/findallpagination")
	@ResponseBody
	public EventPagination getAllPagination(@RequestParam(name = "from", required = false) Long from, @RequestParam(name = "until", required = false) Long until ){
		EventPagination eventPagination = new 		EventPagination();  
		eventPagination.setEvents(eventoService.findAllPagination(from, until));
		eventPagination.setTotalEvents(eventoService.getTotalEvents());
		return eventPagination;
	}
	
	@GetMapping("/{id}")
	public Evento get(@PathVariable Long id) {
		return eventoService.findById(id).get();
	}
	
	@RequestMapping(method = RequestMethod.POST ,produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Evento save(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}
	
	@RequestMapping(method = RequestMethod.PUT, produces={"application/json; charset=UTF-8"})
	@ResponseBody
	public Evento update(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}
	
	@RequestMapping(value = "/{id}" , method = RequestMethod.DELETE)
	@ResponseBody
	public void delete(@PathVariable Long id) {
		eventoService.deleteById(id);
	}

}
