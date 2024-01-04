package com.cursov3.springboot.seccion2.SpringMVC.controllers;

import com.cursov3.springboot.seccion2.SpringMVC.Example.Example;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/seccion2/api")
public class UserController {

    @GetMapping("/details")
    @ResponseStatus(HttpStatus.OK)
    public String details() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        Example ejemplo = new Example("Hola mundo!", LocalDate.now().toString());

        return objectMapper.writeValueAsString(ejemplo);
    }
}
