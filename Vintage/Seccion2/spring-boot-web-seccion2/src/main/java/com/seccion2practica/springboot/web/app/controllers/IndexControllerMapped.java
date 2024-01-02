package com.seccion2practica.springboot.web.app.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/app") // Podemos mapear el controllador. De esta forma podemos realizar las operaciones de CRUD
public class IndexControllerMapped {
	
	
	@GetMapping(value={"/indexMapped"}) 
	public String index(Model model) { 
		model.addAttribute("titulo", "Hola Spring Framework");
		model.addAttribute("txt0", "Controller Mappeado '/app/indexMapped'");
		model.addAttribute("txt1", "Mapped: " + Math.random()*1000);
		return "indexMapped";
	}
	
}