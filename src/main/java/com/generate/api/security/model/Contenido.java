package com.generate.api.security.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Contenido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "sequence")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnoreProperties(value = {"apellidos","password","roles","username","avatar"})
	@JoinColumn(name = "id_user")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_contenido")
	private TipoContenido tipoContenido;
	
	@Column
	private String titulo;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "contenido", fetch = FetchType.EAGER, orphanRemoval = true)
	private Set<ValorCampoContenido> valoresContenido = new HashSet<ValorCampoContenido>();

	
	
	public Contenido() {
		
	}

	public Contenido(Long id, UserEntity user, TipoContenido tipoContenido, String titulo) {
		super();
		this.id = id;
		this.user = user;
		this.tipoContenido = tipoContenido;
		this.titulo = titulo;
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

	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}

	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Set<ValorCampoContenido> getValoresContenido() {
		return valoresContenido;
	}

	public void setValoresContenido(Set<ValorCampoContenido> valoresContenido) {
		this.valoresContenido = valoresContenido;
	}
	
	
	
	
}
