package com.seccion2practica.springboot.web.app.models;

public class Usuario {

	private String nombre;
	private String apellido1;
	private String apellido2;
	private String dni;
	private String email;
	
	//Constructores
	public Usuario() {

	}

	public Usuario(String nombre, String apellido1, String apellido2, String dni, String email) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.dni = dni;
		this.email = email;
	}

	// Get&Set
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return this.nombre + " " + this.apellido1 + " " + this.apellido2 + ". DNI " + this.dni;
	}

}
