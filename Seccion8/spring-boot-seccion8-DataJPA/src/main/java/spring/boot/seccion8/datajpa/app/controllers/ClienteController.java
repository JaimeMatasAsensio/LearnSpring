package spring.boot.seccion8.datajpa.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import spring.boot.seccion8.datajpa.app.models.dao.IClienteDao;

@Controller
public class ClienteController {
	
	@Autowired
	@Qualifier("ClienteDaoJPA") //Para seleccionar el beans concreto en caso de existir varias implementaciones de la misma interfaz
	private IClienteDao clienteDao;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		
		model.addAttribute("titulo","Listado de clientes");
		model.addAttribute("clientes",clienteDao.findAll());
		return "listar";
	}

}
