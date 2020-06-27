package com.generate.api.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class TipoContenido {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"name", "username", "mail", "surname","password", "avatar", "roles"})
	@JoinColumn(name = "id_user")
	private UserEntity user;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	@Column
	private  boolean publico;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoContenido", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<CamposTipoContenido> camposTipoContenido = new HashSet<CamposTipoContenido>();
	
	

	public TipoContenido() {

	}

	public TipoContenido(Long id, UserEntity user, String nombre, String descripcion, boolean publico) {
		this.id = id;
		this.user = user;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.publico = publico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isPublico() {
		return publico;
	}

	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	
	
}
