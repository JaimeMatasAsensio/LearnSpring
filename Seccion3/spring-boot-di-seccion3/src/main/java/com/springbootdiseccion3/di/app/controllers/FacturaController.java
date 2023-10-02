package com.springbootdiseccion3.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbootdiseccion3.di.app.ConstantesSeccion3;
import com.springbootdiseccion3.di.app.models.domain.Factura;

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
