package com.springbootseccion4.form.app.models.domain;

import java.util.Date;
import java.util.List;

//import org.springframework.format.annotation.DateTimeFormat;

import com.springbootseccion4.form.app.validation.IdentificadorRegex;
import com.springbootseccion4.form.app.validation.Requerido;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
//import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
//import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Usuario {
	
	//Parametros//
	
	// @Pattern(regexp="[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
	@IdentificadorRegex
	private String identificador;

	// @NotEmpty
	private String nombre;

	// @NotEmpty
	@Requerido
	private String apellido;

	@NotBlank
	@Size(min = 3, max = 10)
	private String username;

	@Requerido
	private String password;

	@NotEmpty // Validacion de Strings
	@Email
	private String email;

	@NotNull // Validacion de objetos
	@Min(5)
	@Max(500)
	private int cuenta;

	@NotNull
	// @DateTimeFormat(pattern = "yyyy-MM-dd")//Para dar formato a fechas
	@Past // Valida solo fechas en pasado
	// @Future //Valida solo fecha en futuro
	private Date fechaNacimiento;

	@NotNull
	private Pais pais;

	@NotEmpty // Tambien sirve para listas
	private List<Role> roles;

	private Boolean habilitar;
	
	@NotEmpty
	private String sexo;
	
	
	private String valorOculto;
	
	
	//Getters&Setters//
	public Boolean getHabilitar() {
		return habilitar;
	}
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	public void setHabilitar(Boolean activo) {
		this.habilitar = activo;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setCuenta(int cuenta) {
		this.cuenta = cuenta;
	}

	public Integer getCuenta() {
		return cuenta;
	}

	public void setCuenta(Integer cuenta) {
		this.cuenta = cuenta;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public String getUsername() {
		return username;
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

	public void setUsername(String nombre) {
		this.username = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getValorOculto() {
		return valorOculto;
	}

	public void setValorOculto(String valorOculto) {
		this.valorOculto = valorOculto;
	}
	
	
	
}
