package spring.boot.seccion8.datajpa.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import spring.boot.seccion8.datajpa.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	
	
}
