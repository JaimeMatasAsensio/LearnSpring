package com.springbootdiseccion3.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootdiseccion3.di.app.ConstantesSeccion3;
import com.springbootdiseccion3.di.app.models.domain.Factura;

/*
 * Un controller tendra el ambito (scope) de singelton. 
 * Una sola instancia de este objeto sera usada por todos los clientes que accedan a la aplicacion
 * Este ambito es por defecto. Cuando tenemos este ambito los controladores no debenm tener atributos 
 * que sean de un solo usuario ya que estos seran accesibles por el resto de usuarios.
 * Para evitar esto los objetos inyectados deben ser sin estado.
 */
@Controller
@RequestMapping(ConstantesSeccion3.RUTA_FACTURA)
public class FacturaController {
	
	@Autowired
	private Factura factura;
	
	@GetMapping(ConstantesSeccion3.RUTA_DETALLE)
	public String ver(Model model) {
		
		model.addAttribute("factura",factura);
		model.addAttribute("titulo", ConstantesSeccion3.TITULO_FACTURAS);
		
		return ConstantesSeccion3.VISTA_FACTURA_DETALLE;
	}

}
