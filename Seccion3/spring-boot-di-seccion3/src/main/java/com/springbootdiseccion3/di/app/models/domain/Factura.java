package com.springbootdiseccion3.di.app.models.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Factura {

	@Value("${factura.decripcion}")
	private String descripcion;

	private String numero;

	@Autowired
	private Cliente cliente;
	
	@Autowired
	private List<ItemFactura> items;

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

	public Cliente getCleinte() {
		return cliente;
	}

	public void setCleinte(Cliente cleinte) {
		this.cliente = cleinte;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
