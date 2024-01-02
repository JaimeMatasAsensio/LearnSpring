package spring.boot.seccion9.fileupload.app.models.service;

import java.util.List;

import spring.boot.seccion9.fileupload.app.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	
	public void save(Cliente cliente);
	
	public Cliente findOne(Long id);
	
	public void delete(Long id);
}
