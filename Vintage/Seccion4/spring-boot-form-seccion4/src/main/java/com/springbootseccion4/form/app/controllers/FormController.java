package com.springbootseccion4.form.app.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.springbootseccion4.form.app.editors.NombreMayusculaEditor;
import com.springbootseccion4.form.app.editors.PaisPropertyEditor;
import com.springbootseccion4.form.app.editors.RolesEditor;
import com.springbootseccion4.form.app.models.domain.Pais;
import com.springbootseccion4.form.app.models.domain.Role;
import com.springbootseccion4.form.app.models.domain.Usuario;
import com.springbootseccion4.form.app.services.IPaisService;
import com.springbootseccion4.form.app.services.IRoleService;
import com.springbootseccion4.form.app.validation.UsuarioValidator;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("usuario")
public class FormController {
	
	@Autowired
	private UsuarioValidator validador;
	
	@Autowired
	private IPaisService paisService;
	
	@Autowired
	private IRoleService rolService;
	
	@Autowired
	private PaisPropertyEditor paisEditor;
	
	@Autowired
	private RolesEditor rolesEditor;
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(validador);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);//Para indicar si ambiguedades con la fecha
		binder.registerCustomEditor(Date.class,"fechaNacimiento", new CustomDateEditor(dateFormat, false));
		
		binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
		
		binder.registerCustomEditor(Pais.class,"pais", paisEditor);
		
		binder.registerCustomEditor(Role.class,"roles", rolesEditor);
	}
	
	//SEXO
	@ModelAttribute("sexo")
	public List<String> sexo(){
		return Arrays.asList("Hombre","Mujer","Sí");
	}
	
	//ROLES
	@ModelAttribute("listaRoles")
	public List<Role> roles(){
		return this.rolService.listar();
	}
	
	@ModelAttribute("listaRolesString")
	public List<String> listadoRolesString(){
		List<String> roles = new ArrayList<>();
		roles.add("ROLE_ADMINISTRADOR");
		roles.add("ROLE_USUARIO");
		roles.add("ROLE_MODERADOR");
		
		return roles;
	}
	
	@ModelAttribute("listaRolesMap")
	public Map<String,String>  listaRolesMap(){
		Map<String,String> roles = new HashMap<String,String>();
		roles.put("ROLE_ADMINISTRADOR", "Administrador");
		roles.put("ROLE_USUARIO", "Usuario");
		roles.put("ROLE_MODERADOR", "Moderador");
		
		return roles;
	}
	
	//PAISES
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
		return paisService.Listar();
	}
	
	
	//MAPEADO DE PETICIONES
	/* Cada vez que la peticion sea del tipo GET invocara este metodo
	 * */
	@GetMapping("/form")
	public String form(Model model) {
		Usuario usuario = new Usuario();
		usuario.setNombre("Jaime");
		usuario.setApellido("Matas");
		usuario.setHabilitar(true);
		usuario.setIdentificador("123.456.789-X");
		usuario.setValorOculto("(_)_)=======B");
		usuario.setPais(new Pais(7,"AL","Alemania"));
		usuario.setRoles(Arrays.asList(new Role(2, "Usuario", "ROLE_USUARIO")));
		
		model.addAttribute("titulo", "Formulario de usuarios");
		model.addAttribute("usuario", usuario);
		return "form";
	}
	
	/* Cada vez que la peticion sea del tipo POST invocara este metodo
	 * */
	@PostMapping("/form")
	public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
		
		//validador.validate(usuario, result);
				
		if(result.hasErrors()) {
			model.addAttribute("titulo", "Resultado del formulario");
			return "form";
		}
				
		return "redirect:/ver";
	}
	
	@GetMapping("/ver")
	public String ver(@SessionAttribute(name="usuario",required=false)Usuario usuario, Model model, SessionStatus status) {
		
		if(usuario == null) return "redirect:/form";
		model.addAttribute("titulo", "Resultado del formulario");
		
		status.setComplete();
		return "resultado";
	}

}
