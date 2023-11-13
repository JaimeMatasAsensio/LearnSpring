package com.springbootseccion5.form.app.services;

import java.util.List;

import com.springbootseccion5.form.app.models.domain.Pais;

public interface IPaisService {
	
	public List<Pais> Listar();
	
	public Pais obtenerId(Integer id);

}
