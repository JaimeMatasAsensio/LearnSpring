package spring.boot.seccion8.datajpa.app.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import spring.boot.seccion8.datajpa.app.models.dao.IClienteDao;
import spring.boot.seccion8.datajpa.app.models.entity.Cliente;

@Service
public class ClienteServiceImpl implements IClienteService {
	
	@Autowired
	private IClienteDao clienteDao;
	
	@Override
	@Transactional
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		clienteDao.save(cliente);
		
	}

	@Override
	@Transactional
	public Cliente findOne(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
		
	}

}
