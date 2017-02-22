package br.com.fiap.dao;

public interface GenericDAO<T,K> {
	void insert(T entity);
	void update(T entity);
	void delete(K id);
	T findById(K id);
}
