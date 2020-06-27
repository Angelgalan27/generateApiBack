package com.generate.api.security.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CamposTipoContenido {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_contenido")
	private TipoContenido tipoContenido;
	
	@JoinColumn(name = "id_tipo_campo")
	@ManyToOne(fetch = FetchType.EAGER)
	private TipoCampo tipo;
	
	@Column
	private String nombre;
	
	@Column
	private String descripcion;
	
	

	public CamposTipoContenido() {
	}



	public CamposTipoContenido(Long id, TipoContenido tipoContenido, TipoCampo tipo, String nombre,
			String descripcion) {
		this.id = id;
		this.tipoContenido = tipoContenido;
		this.tipo = tipo;
		this.nombre = nombre;
		this.descripcion = descripcion;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public TipoContenido getTipoContenido() {
		return tipoContenido;
	}



	public void setTipoContenido(TipoContenido tipoContenido) {
		this.tipoContenido = tipoContenido;
	}



	public TipoCampo getTipo() {
		return tipo;
	}



	public void setTipo(TipoCampo tipo) {
		this.tipo = tipo;
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
	
	
}
