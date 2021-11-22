package org.iesalixar.drodriguezm.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String nombre;
	private String email;
	private String rol;
	private String password;
	private String firstName;
	private String LastName;

	public Usuario() {}

	public Usuario(String nombre, String email, String rol, String password, String firstName, String lastName) {
		this.nombre = nombre;
		this.email = email;
		this.rol = rol;
		this.password = password;
		this.firstName = firstName;
		LastName = lastName;
	}

	public Usuario(String nombre, String email, String rol, String firstName, String lastName) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.rol = rol;
		this.firstName = firstName;
		LastName = lastName;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", rol=" + rol + ", password=" + password
				+ ", firstName=" + firstName + ", LastName=" + LastName + "]";
	}
}
