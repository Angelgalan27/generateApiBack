package com.generate.api.bean;

import java.util.List;

import com.generate.api.security.model.Evento;

public class EventPagination {

	private List<Evento> events;
	private Long totalEvents;
	
	public List<Evento> getEvents() {
		return events;
	}
	public void setEvents(List<Evento> events) {
		this.events = events;
	}
	public Long getTotalEvents() {
		return totalEvents;
	}
	public void setTotalEvents(Long totalEvents) {
		this.totalEvents = totalEvents;
	}
	
	
}
