package com.cursov3.springboot.seccion2.SpringMVC.controllers;

import com.cursov3.springboot.seccion2.SpringMVC.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/seccion2")
public class UserRestController {



    @GetMapping("/restdetails/{mensaje}")
    public Map<String,Object> details(@PathVariable String mensaje, Model model) throws JsonProcessingException {

        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola Mundo");
        body.put("mensaje",mensaje);
        body.put("date",LocalDate.now().toString());
        body.put("era",LocalDate.now().getEra().toString());

        return body;
    }

    @GetMapping("/restdetails")
    public Map<String,Object> details(){

        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola Mundo");
        body.put("name","Jaime");
        body.put("lastName","Matas");
        body.put("date",LocalDate.now().toString());
        body.put("era",LocalDate.now().getEra().toString());

        return body;

    }

    @GetMapping("/restdetails/user")
    public Map<String,Object> detailsUser(){
        User user = new User("Jaime","Matas");
        Map<String,Object> body = new HashMap<>();
        body.put("title","Hola Mundo");
        body.put("user",user);
        body.put("date",LocalDate.now().toString());
        body.put("era",LocalDate.now().getEra().toString());

        return body;

    }
}
