package com.cursov3.springboot.seccion2.SpringMVC.controllers;


import com.cursov3.springboot.seccion2.SpringMVC.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/seccion2")
public class UserController {

    private ObjectMapper om = new ObjectMapper();

    @GetMapping("/details/{mensaje}")
    @ResponseStatus(HttpStatus.OK)
    public String details(@PathVariable String mensaje, Model model) throws JsonProcessingException {

        Map<String,Object> body = new HashMap<>();

        body.put("title","Hola Mundo");body.put("mensaje",mensaje);
        body.put("date",LocalDate.now().toString());
        body.put("era",LocalDate.now().getEra().toString());

        return "details";
    }

    @GetMapping("/details")
    @ResponseStatus(HttpStatus.OK)
    public String details(Model model) throws JsonProcessingException {


        model.addAttribute("title","Hola Mundo");
        model.addAttribute("name","Jaime");
        model.addAttribute("lastName","Matas");
        model.addAttribute("date",LocalDate.now().toString());
        model.addAttribute("era",LocalDate.now().getEra().toString());


        return "details";
    }

    @GetMapping("/details/user")
    public String detailsUser(){
        User user = new User("Jaime","Matas");
        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola Mundo");
        body.put("user",user);
        body.put("date",LocalDate.now().toString());
        body.put("era",LocalDate.now().getEra().toString());

        return "details";

    }
}
