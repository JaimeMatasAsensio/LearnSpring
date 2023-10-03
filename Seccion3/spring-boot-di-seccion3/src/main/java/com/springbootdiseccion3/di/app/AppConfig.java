package com.springbootdiseccion3.di.app;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.springbootdiseccion3.di.app.models.domain.ItemFactura;
import com.springbootdiseccion3.di.app.models.domain.Producto;
import com.springbootdiseccion3.di.app.models.service.IServicio;
import com.springbootdiseccion3.di.app.models.service.MiServicio;
import com.springbootdiseccion3.di.app.models.service.MiServicioComplejo;


@Configuration
public class AppConfig {
	
	//Mediante esta configuracion podemos Crear e inyectar las dependencias.
	
	@Bean("miServicioSimple")
	@Primary
	public IServicio registrarServicio() {
		return new MiServicio();
	}
	
	@Bean("miServicioComplejo")
	public IServicio registrarServicioComplejo() {
		return new MiServicioComplejo();
	}
	
	@Bean("itemsFactura")
	public List<ItemFactura> registrarItems(){
		
		Producto producto1 = new Producto("Camiseta",50.01);
		Producto producto2 = new Producto("Pantalon",49.99);
		
		ItemFactura linea1 = new ItemFactura(producto1, 2);
		ItemFactura linea2 = new ItemFactura(producto2, 2);
		
		
		return Arrays.asList(linea1,linea2);
	}
	
	@Bean("itemsFactura1")
	public List<ItemFactura> registrarItems1(){
		
		Producto producto1 = new Producto("Calleras",50.01);
		Producto producto2 = new Producto("muñequeras",39.99);
		Producto producto3 = new Producto("Calcetines",29.99);
		Producto producto4 = new Producto("Tape",9.99);
		
		ItemFactura linea1 = new ItemFactura(producto1, 1);
		ItemFactura linea2 = new ItemFactura(producto2, 1);
		ItemFactura linea3 = new ItemFactura(producto3, 4);
		ItemFactura linea4 = new ItemFactura(producto4, 10);
		
		
		return Arrays.asList(linea1, linea2, linea3, linea4);
	}

}
