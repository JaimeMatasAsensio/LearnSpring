package com.springbootdiseccion3.di.app.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//@Component("miServicioPrincipal")
@Primary //Cuando dos clases implementan una misma interfaz se puede indicar cual de las dos es la primaria
public class MiServicio implements IServicio {
	
	@Override
	public String operacion() {
		return "Servicio Simple implementado con interfaz";
	}

}
