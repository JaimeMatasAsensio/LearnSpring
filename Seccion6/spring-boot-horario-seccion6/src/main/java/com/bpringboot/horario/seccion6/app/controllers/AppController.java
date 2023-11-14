package com.bpringboot.horario.seccion6.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
public class AppController {
	
	@Value("${config.horario.apertura}")
	private Integer apertura;
	
	@Value("${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
		model.addAttribute("titulo","Bienvenido al horario de atencion a clientes");
		return "index";
	}
	
	@GetMapping("/cerrado")
	public String cerrado(Model model) {
		
		StringBuilder mensaje = new StringBuilder("Cerrado por favor visitenos desde las ");
		mensaje.append(apertura);
		mensaje.append(" hrs hasta las ");
		mensaje.append(cierre);
		mensaje.append(" hrs. Disculpen las molestias.");
		model.addAttribute("mensaje", mensaje.toString());
		model.addAttribute("titulo","Fuera de horario de atencion");
		
		return "cerrado";
	}
	
}
