package com.bolsadeideas.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.app.models.entity.Client;

@Repository
public class ClientDaoImpl implements IClientDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Client").getResultList();
	}

	@Transactional(readOnly = false)
	@Override
	public void save(Client client) {
		// TODO Auto-generated method stub
		entityManager.persist(client);
		
	}

}
