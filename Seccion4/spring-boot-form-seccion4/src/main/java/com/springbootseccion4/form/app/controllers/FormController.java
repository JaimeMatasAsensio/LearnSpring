package com.springbootseccion4.form.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springbootseccion4.form.app.domain.Usuario;
import com.springbootseccion4.form.app.validation.UsuarioValidator;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidator validador;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
	}
	
	
	/* Cada vez que la peticion sea del tipo GET invocara este metodo
	 * */
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jaime");
		usuario.setApellido("Matas");
		usuario.setIdentificador("123.456.789-X");
		model.addAttribute("titulo", "Formulario de usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	/* Cada vez que la peticion sea del tipo POST invocara este metodo
	 * */
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
		
		validador.validate(usuario, result);
		
		model.addAttribute("titulo", "Resultado del formulario");
		
		if(result.hasErrors()) {
			
			return "form";
		
		}
		
		model.addAttribute("usuario", usuario);
		status.setComplete();
		return "resultado";
	}

}
