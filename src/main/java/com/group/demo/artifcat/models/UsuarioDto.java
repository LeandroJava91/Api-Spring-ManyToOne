package com.group.demo.artifcat.models;

public class UsuarioDto {
	
	
	    private String nombre;
	    private String apellido;
	    private String nombreMedio;

	    public UsuarioDto(String nombre, String apellido, String nombreMedio) {
	        this.nombre = nombre;
	        this.apellido = apellido;
	        this.nombreMedio = nombreMedio;
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

	    public String getNombreMedio() {
	        return nombreMedio;
	    }

	    public void setNombreMedio(String nombreMedio) {
	        this.nombreMedio = nombreMedio;
	    }
	}


