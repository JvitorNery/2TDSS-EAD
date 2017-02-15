package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Sexo;

public class TesteRefresh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar Funcionario
		Funcionario func = em.find(Funcionario.class, 1);
		
		//alterar valores do funcionário
		func.setNome("teste");
		System.out.println("alterou o nome para: "+func.getNome());
		
		
		//Atualizar funcionário
		em.refresh(func);
		
		System.out.println("após refresh o nome é: "+func.getNome());
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		System.exit(0);
	}

}
