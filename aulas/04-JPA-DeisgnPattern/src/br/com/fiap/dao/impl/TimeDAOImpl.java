package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.dao.TimeDAO;
import br.com.fiap.entity.Time;
import br.com.fiap.singleton.EntityManagerFacotorySingleton;

public class TimeDAOImpl extends GenericDAOImpl implements TimeDAO{

	EntityManager em;

	public TimeDAOImpl(EntityManager em){
		super(em);
	}
	
	@Override
	public void insert(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Time time) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Time select(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	/*public TimeDAOImpl(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public void insert(Time time) {
		//iniciar e finazizar transação
		em.getTransaction().begin();
		em.persist(time);
		em.getTransaction().commit();

	}

	@Override
	public void update(Time time) {
		// TODO Auto-generated method stub
		em.getTransaction().begin();
		em.merge(time);
		em.getTransaction().commit();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		Time t = em.find(Time.class, id);
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	@Override
	public Time select(int id) {
		// TODO Auto-generated method stub
		em.find(Time.class,id);
		return null;
	}*/
	
	
	
	
}
