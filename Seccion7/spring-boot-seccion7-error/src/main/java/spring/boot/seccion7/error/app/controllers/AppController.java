package spring.boot.seccion7.error.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AppController {
	
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
}
