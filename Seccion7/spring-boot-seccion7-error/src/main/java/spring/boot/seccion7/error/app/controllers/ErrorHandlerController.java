package spring.boot.seccion7.error.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;



@ControllerAdvice //Notacion que maneja las excepciones, Mapea a una excepcion
public class ErrorHandlerController {
	
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError(ArithmeticException ex, Model model) {
		model.addAttribute("error","Error de aritmetica");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp",new Date());
		model.addAttribute("clown","Aprende a sumar, ¡Melon!");
		return "error/aritmetica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String numberFormatException(NumberFormatException ex, Model model) {
		model.addAttribute("error","Error numero no valido");
		model.addAttribute("message",ex.getMessage());
		model.addAttribute("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
		model.addAttribute("timestamp",new Date());
		model.addAttribute("clown","Aprende a escribir, ¡Melon!");
		return "error/generico";
	}
}
