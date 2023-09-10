package com.seccion2practica.springboot.web.app.controllers;


import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

@Controller 
public class IndexControllerData {
	
	
	@GetMapping(value={"/indexData"}) 
	public String index(Model model) { // Para introducir datos en la vista podemos pasar la interfaz model de spring
		model.addAttribute("titulo", "Hola Spring Framework");
		model.addAttribute("texto", "Model: " + (Math.random()*1000));
		return "indexData";
	}
	
	@GetMapping(value={"/homeData"}) 
	public String indexA(ModelMap model) { //Podemos usar de la misma forma Model Map
		model.addAttribute("titulo", "Hola Spring Framework");
		model.addAttribute("texto", "ModelMap: " + Math.random()*1000);
		return "indexData";
	}
	
	@GetMapping(value={"/homeDataMap"}) 
	public String indexB(Map<String, Object> map) { //Podemos usar de la misma forma  Map
		map.put("titulo", "Hola Spring Framework");
		map.put("texto", "Map: " + Math.random()*1000);
		return "indexData";
	}
	
	@GetMapping(value={"/homeDataMV"}) 
	public ModelAndView indexB(ModelAndView mv) { //Podemos usar de la misma forma ModelAndView
		mv.addObject("titulo", "Hola Spring Framework");
		mv.addObject("texto", "MV: " + Math.random()*1000);
		mv.setViewName("indexData");
		return mv;
	}
}