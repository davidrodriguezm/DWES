package org.iesalixar.drodriguezm.model;

import java.io.Serializable;
import java.util.List;

public class Reserva implements Serializable {
	private String inicio;
	private String fin;
	private int personas;
	private List<String> servicio;
	
	public Reserva() {}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}

	public List<String> getServicio() {
		return servicio;
	}

	public void setServicio(List<String> servicio) {
		this.servicio = servicio;
	}	

}
