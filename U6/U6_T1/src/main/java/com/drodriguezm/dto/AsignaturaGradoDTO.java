package com.drodriguezm.dto;

import java.io.Serializable;

public class AsignaturaGradoDTO implements Serializable{
	private Long gradoId;
	private Long asignaturaId;
	
	public AsignaturaGradoDTO() {
		super();
	}

	public AsignaturaGradoDTO(Long gradoId, Long asignaturaId) {
		super();
		this.gradoId = gradoId;
		this.asignaturaId = asignaturaId;
	}

	public Long getGradoId() {
		return gradoId;
	}

	public void setGradoId(Long gradoId) {
		this.gradoId = gradoId;
	}

	public Long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(Long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}
	
}
