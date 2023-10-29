package com.springbootseccion4.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springbootseccion4.form.app.editors.NombreMayusculaEditor;
import com.springbootseccion4.form.app.models.domain.Pais;
import com.springbootseccion4.form.app.models.domain.Usuario;
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
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);//Para indicar si ambiguedades con la fecha
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, false));
		
		binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
	}
	
	@ModelAttribute("paises")
	public List<String>  paises(){
		return Arrays.asList("España","Italia","Grecia","Malta","Tunez","Argelia");
	}
	
	@ModelAttribute("paisesMap")
	public Map<String,String>  paisesMap(){
		Map<String,String> paises = new HashMap<String,String>();
		paises.put("ES", "España");
		paises.put("IT", "Italia");
		paises.put("GE", "Grecia");
		paises.put("MA", "Malta");
		paises.put("AR", "Argelia");
		
		return paises;
	}
	
	@ModelAttribute("listaPaises")
	public List<Pais>  listaPaises(){
		return Arrays.asList(
				new Pais(1,"ES","España"),
				new Pais(2,"IT","Italia"),
				new Pais(3,"GE","Grecia"),
				new Pais(4,"MA","Malta"),
				new Pais(5,"TU","Tunez"),
				new Pais(6,"AR","Argelia"));
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
