package com.springbootseccion5.form.app.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springbootseccion5.form.app.models.domain.Role;

@Service
public class RoleServiceImp implements IRoleService{
	
	private List<Role> lista;
	
	public RoleServiceImp() {
		this.lista = new ArrayList<>();
		this.lista.add(new Role(1, "Administrador", "ROLE_ADMIN"));
		this.lista.add(new Role(2, "Usuario", "ROLE_USUARIO"));
		this.lista.add(new Role(3, "Moderador", "ROLE_MODERADOR"));
		this.lista.add(new Role(4, "Anonimo", "ROLE_ANONIMO"));
	}

	@Override
	public List<Role> listar() {

		return lista;
		
	}

	@Override
	public Role obtenerId(Integer id) {
		
		return lista.stream().filter(lst -> lst.getId().equals(id)).findFirst().orElse(null);
		
	}
	
}
