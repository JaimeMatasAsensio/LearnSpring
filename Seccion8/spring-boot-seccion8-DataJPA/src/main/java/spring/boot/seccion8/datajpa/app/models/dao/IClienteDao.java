package spring.boot.seccion8.datajpa.app.models.dao;

import java.util.List;

import spring.boot.seccion8.datajpa.app.models.entity.Cliente;

public interface IClienteDao {
	
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
}
