package com.seccion2practica.springboot.web.app.controllers;

// Imports por las notaciones de Spring
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//Imports para utilizar los request.
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

/* Todas las clases que controlan una vista de denominan como {NombreVista}Controller
 * De este modo indicamos que clases son
 * 
 */

/* Con la notacion @Controller indicamos que esta clase hara las gestiones sobre esta vista
 * Carga de la vista, solicitud de formularios, acceso a BBDD
 * El controlador se hace cargo de manejar las peticiones del usuario.
 * */ 
@Controller 
public class IndexController {
	
	//Los metodos seran publicos y cargaran vistas, realizaran acciones de CRUD
	//@RequestMapping(value="/index")
	//@RequestMapping(value="/index", method=RequestMethod.GET) // Podemos indicar especificamente el metodo del Request
	//@RequestMapping(value={"/index","/home"})
	
	// Existen distintos tipos de Request GET,POST,DELETE,PUT
	@GetMapping(value={"/index","/home"}) // Podemos mapear la vista con distintas rutas
	public String index() {
		
		return "index";
	}
	
}
