package com.seccion2practica.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class VariablesRutasController {
	
	@GetMapping("/")
	public String index (Model model) {
		model.addAttribute("titulo", "Enviar paramentros por  @PathVariable");
		return "variables/indexVar";
	}
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo", "Recibir paramentros de @PathVariable");
		model.addAttribute("texto", "El texto enviado en la ruta es: " + texto);
		
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		model.addAttribute("titulo", "Recibir paramentros de @PathVariable");
		model.addAttribute("texto", "El texto enviado en la ruta es: " + texto);
		model.addAttribute("numero", "El numero enviado en la ruta es: " + numero);
		
		return "variables/ver";
	}
	
}
