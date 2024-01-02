package com.springbootdiseccion3.di.app.models.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * Factura tiene el ambito de sesion. Cada usuario que se conecte tendra una factura distinta y propia.
 * los valores no se alteraran por otros usuarios.
 * */
@RequestScope //Ambito de peticion
/* Este ambito durara el tiempo de que dure la sesion del usuario, hasta que se cierre el navegador u ocurra un TimeOut
 * Debe implementar la interfaz serializable, para poder guardar el objeto en sesiones HTTP. Tambien se usa para JPA 
 * para los objetos relacionados con la persistencias. 
 * */
//@SessionScope //Ambito de sesion (Ej:carrito, inicio de sesion)

/*
 * Similar al Singelton con la diferencia de que se guarda en el servelt context. En una aplicacion web solo tendremos un 
 * ApplicationScope
 * */
//@ApplicationScope
@Component
public class Factura implements Serializable{

	/**
	 * Este atributo es no tiene impacto sobre el codigo, es un identificador de la serializacion
	 */
	private static final long serialVersionUID = 1L;

	@Value("${factura.descripcion}")
	private String descripcion;

	private String numero;

	@Autowired
	private Cliente cliente;
	
	@Autowired
	@Qualifier("itemsFactura1")
	private List<ItemFactura> items;
	
	@PostConstruct //Se ejecuta despues de crear el objeto de haber relizado la inyeccion de la dependencia
	public void inicializar(){
		
		cliente.setNombre(cliente.getNombre().concat(" ").concat("Alberto"));
		this.descripcion = descripcion.concat(" de cliente: ").concat(cliente.getNombre()).concat(" ").concat(cliente.getApellido());
		
	}
	
	@PreDestroy
	public void destruir() {
		System.out.println("Factura destruida".concat(descripcion));
	}
	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cleinte) {
		this.cliente = cleinte;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
