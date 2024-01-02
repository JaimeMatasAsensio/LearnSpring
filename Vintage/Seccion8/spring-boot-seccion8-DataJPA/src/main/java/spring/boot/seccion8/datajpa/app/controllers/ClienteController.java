package spring.boot.seccion8.datajpa.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import jakarta.validation.Valid;
import spring.boot.seccion8.datajpa.app.models.entity.Cliente;
import spring.boot.seccion8.datajpa.app.models.service.IClienteService;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",clienteService.findAll());
		return "listar";
	}
	
	@GetMapping("/form")
	public String crear(Map<String, Object> model) {
		Cliente cliente = new Cliente();
		
		model.put("cliente", cliente);
		model.put("titulo", "Formulario de cliente");
		
		
		return "form";
	}
	
	@GetMapping("/form/{id}")
	public String editar(@PathVariable(value = "id")Long id, Map<String, Object> model) {
		Cliente cliente = null;
		if(id != null && id > 0) {
			cliente = clienteService.findOne(id);
		}else {
			return "redirect:/listar";
		}
		model.put("cliente", cliente);
		model.put("titulo", "Editar de cliente");
		
		return "form";
	}
	
	@PostMapping("/form")
	public String guardar(@Valid @ModelAttribute Cliente cliente, BindingResult result, Model model, SessionStatus session) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de cliente");
			return "form";
		}
		
		clienteService.save(cliente);
		
		session.setComplete();
		return "redirect:/listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id != null && id > 0) {
			clienteService.delete(id);
		}
		return "redirect:/listar";
	}
	
}
