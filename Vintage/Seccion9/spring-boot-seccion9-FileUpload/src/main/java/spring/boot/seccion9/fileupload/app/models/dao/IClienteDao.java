package spring.boot.seccion9.fileupload.app.models.dao;



import org.springframework.data.repository.CrudRepository;

import spring.boot.seccion9.fileupload.app.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{
	
	
	
}
