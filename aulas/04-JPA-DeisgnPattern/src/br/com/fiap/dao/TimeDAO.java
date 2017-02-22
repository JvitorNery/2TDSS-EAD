package br.com.fiap.dao;

import br.com.fiap.entity.Time;

public interface TimeDAO extends GenericDAO<Time,Integer>{
	void insert(Time time);
	void update(Time time);
	void delete(int id);
	Time select(int id);
}
