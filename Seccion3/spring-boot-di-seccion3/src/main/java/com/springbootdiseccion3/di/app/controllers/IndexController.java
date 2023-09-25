package com.springbootdiseccion3.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.springbootdiseccion3.di.app.ConstantesSeccion3;
import com.springbootdiseccion3.di.app.models.service.IServicio;


@Controller
public class IndexController {
	
	//Inyeccion de dependencias mediante Atributo
	@Autowired
	//@Qualifier("miServicioComplejo")//Con esta anotacion podemos indicar cual de los dos servicios queremos implementar
	private IServicio servicio;
	

	@GetMapping({"/index","/",""})
	public String index(Model model) {
		model.addAttribute("titulo", ConstantesSeccion3.TITULO_SECCION3);
		model.addAttribute("objeto",servicio.operacion());
		return "index";
	}
	
	
//	//Otras formas de inyectar dependecia a una clase
//	//Via Constructor
//	@Autowired
//	public void setServicio(IServicio servicio) {
//		this.servicio = servicio;
//	}
//	
//	//Via metodo
//	@Autowired
//	public IndexController(IServicio servicio) {
//		this.servicio = servicio;
//	}
	

}
