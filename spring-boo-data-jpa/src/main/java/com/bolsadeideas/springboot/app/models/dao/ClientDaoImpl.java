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
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Client> findAll() {
		// TODO Auto-generated method stub
		return entityManager.createQuery("from Client").getResultList();
	}

	@Override
	@Transactional
	public void save(Client client) {
		// TODO Auto-generated method stub
		if (client.getId() != null && client.getId() > 0) {
			entityManager.merge(client);
		} else {
			entityManager.persist(client);	
		}
	}

	@Override
	public Client findOne(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Client.class, id);
	}

}
