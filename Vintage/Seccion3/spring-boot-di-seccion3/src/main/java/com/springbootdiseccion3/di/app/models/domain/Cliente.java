package com.springbootdiseccion3.di.app.models.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/*
 * Cliente requiere tambien de un ambito de sesion. Sin este ambito  Estaremos concatenando el nombre 
 * dado en el metodo inicializar de la clase Factura. Esto ocurre por que cliente es unico y atomico. Una sola
 * instancia para toda a aplicacion. De esta forma con @RequestScope Crearemos y destruiremos el objeto en cada sesion
 * 
 * Factura y Cliente ahora estaran en el mismo ambito y por lo tanto se crean y destruyen en cada sesion
 * */
@Component
@RequestScope //Comenta esto y dale a refresh... veras que pasa.
public class Cliente {
	
	@Value("${cliente.nombre}")
	private String nombre;
	
	@Value("${cliente.apellido}")
	private String apellido;
	
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

}
