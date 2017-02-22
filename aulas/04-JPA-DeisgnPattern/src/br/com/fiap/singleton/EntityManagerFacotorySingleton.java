package br.com.fiap.singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFacotorySingleton {
	//atributo est�tico
	private static EntityManagerFactory fabrica;
	//construtor privado
	private EntityManagerFacotorySingleton(){
		
	}
	//m�todo getinstance
	public static EntityManagerFactory getInstance(){
		if(fabrica == null){
			fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE"); 
		}
		return 	fabrica;
	}
}
