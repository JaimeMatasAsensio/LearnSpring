package com.springbootseccion5.form.app.services;

import java.util.List;

import com.springbootseccion5.form.app.models.domain.Role;

public interface IRoleService {
	
	public List<Role> listar();
	
	public Role obtenerId(Integer id);
	
}
