package com.drodriguezm.dto;

import java.io.Serializable;

public class GradoDTO implements Serializable {
	private String nombre;

	public GradoDTO() {
		super();
	}

	public GradoDTO(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
