package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {
 public static void main(String[] args){
	 //criar o gerenciador de entidades
	 
	 //criar a fábrica de entity manager
	 EntityManagerFactory fabrica = //valor configurado no persistence
			 Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
	 
	 EntityManager em = fabrica.createEntityManager();//criando gerenciador de entidades
	 
 }
}
