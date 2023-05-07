package com.group.demo.artifcat.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Usuario")
//@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsu;
	
	private String nombre;
	
	private String apellido;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transporte_id")
	 @JsonProperty(access = Access.WRITE_ONLY)
   	private Transporte transporte;

	public int getIdUsu() {
		return idUsu;
	}

	public void setIdUsu(int idUsu) {
		this.idUsu = idUsu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	
	

}
