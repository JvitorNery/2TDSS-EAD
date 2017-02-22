package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;
import java.lang.reflect.ParameterizedType;
import br.com.fiap.dao.GenericDAO;

public class GenericDAOImpl<T,K> implements GenericDAO<T,K>{

	EntityManager em;
	
	private Class<T> clazz;
	
	@SuppressWarnings("all")
	public GenericDAOImpl(EntityManager em){
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}
	
	
	@Override
	public void insert(T entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	

	@Override
	public void update(T entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
	}

	@Override
	public void delete(K id) {
		em.getTransaction().begin();
		em.remove(em.findById(id));
		em.getTransaction().commit();
	}

	@Override
	public T findById(K id) {
		em.find(T.class, id);
		return null;
	}

	
	
}
