package com.group.demo.artifcat.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Transporte")
public class Transporte {
	
	
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	private String nombreMedio;
	
	
	 @OneToMany(mappedBy = "transporte",cascade = CascadeType.ALL)
	    private List<Usuario> usuarios;


	public Integer getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getNombreMedio() {
		return nombreMedio;
	}


	public void setNombreMedio(String nombreMedio) {
		this.nombreMedio = nombreMedio;
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}


	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	
	
}
