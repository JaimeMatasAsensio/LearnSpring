package com.seccion2practica.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class ParamsController {
	
	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("titulo","Enviar paramentros del request HTTP GET - URL");
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required=false, defaultValue = "No se enviaron parametros") String texto, Model model) {
		
		model.addAttribute("titulo","Recibir paramentros del request HTTP GET - URL");
		model.addAttribute("resultado","Resultado capturado: " + texto);
		return "params/ver";
	}

}
