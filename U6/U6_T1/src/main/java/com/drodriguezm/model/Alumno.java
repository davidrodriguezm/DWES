package com.drodriguezm.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.drodriguezm.model.AlumnoAsignatura;

@Entity
@Table(name="alumno")
public class Alumno implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="nif",nullable=false)
	private String nif;
	
	@Column(name="nombre", nullable=false)
	private String nombre;
	
	@Column(name="apellido1",nullable=false)
	private String apellido1;
	
	@Column(name="apellido2",nullable=false)
	private String apellido2;
	
	@Column(name="ciudad",nullable=false)
	private String ciudad;
	
	@Column(name="direccion",nullable=false)
	private String direccion;
	
	@Column(name="telefono",nullable=false)
	private String telefono;
	
	@Column(name="fecha_nacimiento",nullable=false)
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(nullable=false,length=1)
	private String sexo;
	
	@OneToMany(mappedBy="alumno",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<AlumnoAsignatura> alumnoAsignaturas = new HashSet<>();

	public Alumno() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Set<AlumnoAsignatura> getAlumnoAsignaturas() {
		return alumnoAsignaturas;
	}

	public void setAlumnoAsignaturas(Set<AlumnoAsignatura> alumnoAsignatura) {
		this.alumnoAsignaturas = alumnoAsignatura;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(id, other.id) || Objects.equals(nif, other.nif);
	}
	
	public static Date dateFactory( int year, int month, int day) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month);
		calendar.set(Calendar.DAY_OF_MONTH, day);
		return calendar.getTime();	
	}

}
