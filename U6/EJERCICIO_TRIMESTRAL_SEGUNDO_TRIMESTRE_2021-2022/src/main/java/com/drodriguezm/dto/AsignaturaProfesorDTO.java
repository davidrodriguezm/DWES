package com.drodriguezm.dto;

import java.io.Serializable;

public class AsignaturaProfesorDTO implements Serializable{
	private Long profesorId;
	private Long asignaturaId;
	
	public AsignaturaProfesorDTO() {
		super();
	}

	public AsignaturaProfesorDTO(Long profesorId, Long asignaturaId) {
		super();
		this.profesorId = profesorId;
		this.asignaturaId = asignaturaId;
	}

	public Long getProfesorId() {
		return profesorId;
	}

	public void setProfesorId(Long profesorId) {
		this.profesorId = profesorId;
	}

	public Long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(Long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}
	
}
