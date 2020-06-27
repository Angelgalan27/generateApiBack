package com.generate.api.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoCampo {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	private String tipo;
	
	@Column
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContenido", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<CamposTipoContenido> CamposTipoContenido = new HashSet<CamposTipoContenido>();


	public TipoCampo() {
	}

	public TipoCampo(Long id, String tipo, String descripcion) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	
	
}
