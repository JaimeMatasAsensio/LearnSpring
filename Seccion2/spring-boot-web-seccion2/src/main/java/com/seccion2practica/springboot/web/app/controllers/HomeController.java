package com.seccion2practica.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "redirect:/index";
	}
	
	@GetMapping("/google")
	public String google() {
		return "redirect:https://www.google.com";
	}
	
	@GetMapping("/forward")
	public String home1() {
		return "forward:/app/indexData";
	}

}
