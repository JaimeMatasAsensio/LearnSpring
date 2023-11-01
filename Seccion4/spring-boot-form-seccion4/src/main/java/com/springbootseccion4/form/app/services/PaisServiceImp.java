package com.springbootseccion4.form.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springbootseccion4.form.app.models.domain.Pais;

@Service
public class PaisServiceImp implements IPaisService {
	
	private List<Pais> lista;
	
	public PaisServiceImp() {
		this.lista = Arrays.asList(
				new Pais(1,"ES","España"),
				new Pais(2,"IT","Italia"),
				new Pais(3,"GE","Grecia"),
				new Pais(4,"MA","Malta"),
				new Pais(5,"TU","Tunez"),
				new Pais(6,"AR","Argelia"),
				new Pais(7,"AL","Alemania"));

	}

	@Override
	public List<Pais> Listar() {

		return lista;
	}

	@Override
	public Pais obtenerId(Integer id) {
		
		return lista.stream().filter(lst -> lst.getId().equals(id)).findFirst().orElse(null);
		
	}

}
