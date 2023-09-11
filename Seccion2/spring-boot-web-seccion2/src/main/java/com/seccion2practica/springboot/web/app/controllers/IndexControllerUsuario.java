package com.seccion2practica.springboot.web.app.controllers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.seccion2practica.springboot.web.app.models.Usuario;

import org.springframework.ui.Model;

//Mapeamos este controlador para la ruta /app
@Controller
@RequestMapping("/app")
public class IndexControllerUsuario {
	
	public static String NAME_CLASS = "IndexControllerUsuario";
	
	// Con /app/indexData ejecutamos este metodo
	@GetMapping(value={"/indexData"}) 
	public String index(Model model) { // Para introducir datos en la vista podemos pasar la interfaz model de spring
		
		model.addAttribute("dato", NAME_CLASS);
		model.addAttribute("titulo", "Hola Spring Framework");
		model.addAttribute("texto", "Model: " + (Math.random()*1000));
		return "indexData";
	}
	// Con /app/perfil ejecutamos este metodo
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		//Creamos el objeto usuario
		Usuario usuario = new Usuario();
		
		//Poblamos los paramentros (En ambiente real vendria de BBDD)
		usuario.setNombre("Jaime");
		usuario.setApellido1("Matas");
		usuario.setApellido2("Asensio");
		usuario.setDni("000000000-X");
		//usuario.setEmail("correo@correo.es");
		
		//Añadimos datos al modelo y etiquetado de thymeleaf
		model.addAttribute("titulo", "Framework Spring");
		model.addAttribute("texto", "Perfil Usuario: ".concat(usuario.getNombre()));
		model.addAttribute("dato", NAME_CLASS);
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios =  Arrays.asList(
				new Usuario ("Jaime","Matas","Asensio","000000000-X","Jaime@correo.com"),
				new Usuario ("Veronica","Code","Bug","000000000-Y","Veronica@correo.com"),
				new Usuario ("Anonymous","Empty","Empty","000000000-Z","Anonymous@correo.com")
				);
		
		model.addAttribute("dato", NAME_CLASS);
		model.addAttribute("titulo", "Framework Spring");
		
		model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
}