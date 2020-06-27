package com.generate.api.security.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class ValorCampoContenido {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	@JoinColumn(name = "id_contenido")
	private Contenido contenido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"tipoContenido"})
	@JoinColumn(name = "id_campo_tipo_contenido")
	private CamposTipoContenido campoTipoContenido;
	
	@Column
	private String value;
	
	

	public ValorCampoContenido() {

	}

	public ValorCampoContenido(Long id, Contenido contenido, CamposTipoContenido campoTipoContenido, String value) {
		super();
		this.id = id;
		this.contenido = contenido;
		this.campoTipoContenido = campoTipoContenido;
		this.value = value;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Contenido getContenido() {
		return contenido;
	}

	public void setContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	public CamposTipoContenido getCampoTipoContenido() {
		return campoTipoContenido;
	}

	public void setCampoTipoContenido(CamposTipoContenido campoTipoContenido) {
		this.campoTipoContenido = campoTipoContenido;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
