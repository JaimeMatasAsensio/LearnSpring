package spring.boot.seccion8.datajpa.app.models.entity;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import spring.boot.seccion8.datajpa.app.models.dao.IClienteDao;

@Repository("ClienteDaoJPA")
public class ClienteDaoImpl implements IClienteDao {
	
	@PersistenceContext	
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Cliente> findAll() {
		return em.createQuery("from Cliente").getResultList();
	}
	
	@Override
	@Transactional
	public Cliente findOne(Long id) {
		
		return em.find(Cliente.class, id);
		
	}

	@Override
	@Transactional
	public void save(Cliente cliente) {
		if(cliente.getId() != null && cliente.getId() > 0) {
			em.merge(cliente);
		}else {
			em.persist(cliente);
		}
				
	}

	
	@Override
	@Transactional
	public void delete(Long id) {
		
		em.remove(findOne(id));	
	
	}

}
