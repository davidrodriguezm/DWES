package org.iesalixar.drodriguezm.model;

import java.io.Serializable;

public class Usuario implements Serializable {
	private String nombre;
	private String email;
	private String password;
	private String role;
	private String firstName;
	private String lastName;

	public Usuario() {}

	public Usuario(String nombre, String email, String password ,String role , String firstName, String lastName) {
		this.nombre = nombre;
		this.email = email;
		this.role = role;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Usuario(String nombre, String email, String role, String firstName, String lastName) {
		this.nombre = nombre;
		this.email = email;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Usuario(String nombre, String email, String role) {
		super();
		this.nombre = nombre;
		this.email = email;
		this.role = role;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", email=" + email + ", role=" + role + "]";
	}
}
