package spring.boot.seccion7.error.app.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import spring.boot.seccion7.error.app.errors.UsuarioNotFoundException;
import spring.boot.seccion7.error.app.models.domain.Usuario;
import spring.boot.seccion7.error.app.services.IUsuarioService;



@Controller
public class AppController {
	
	private IUsuarioService usuarioService;
	
	public AppController(IUsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index() {
		Integer valor = 100/0;
		return "index";
	
	}
	
	@SuppressWarnings("unused")
	@GetMapping("/")
	public String index2() {
		Integer valor = Integer.parseInt("100X");
		return "index";
	
	}
	
	@GetMapping("/ver/{id}")
	public String verUsuario(@PathVariable Integer id, Model model) {
		
		Usuario usuario = usuarioService.obtenerPorId(id).orElseThrow(()-> new UsuarioNotFoundException(id.toString()));
		
		model.addAttribute("usuario",usuario);
		model.addAttribute("titulo","Detalle usuario: "
				.concat(usuario.getNombre())
				.concat(" ")
				.concat(usuario.getApellido())
				.concat(". Id: ")
				.concat(usuario.getId().toString()));
		return "ver";
	}
	
}
