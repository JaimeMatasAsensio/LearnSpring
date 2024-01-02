package com.springbootseccion4.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springbootseccion4.form.app.services.IRoleService;

@Component
public class RolesEditor extends PropertyEditorSupport{

	@Autowired
	private IRoleService service;
	
	@Override
	public void setAsText(String idString) throws IllegalArgumentException {
		try {
			setValue(service.obtenerId(  Integer.parseInt(idString)) );
		} catch (NumberFormatException e) {
			setValue(null);
		}
	}
	
}
