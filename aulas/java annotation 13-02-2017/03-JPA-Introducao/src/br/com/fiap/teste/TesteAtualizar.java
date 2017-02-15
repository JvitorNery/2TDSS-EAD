package br.com.fiap.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Sexo;

public class TesteAtualizar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar Funcionario
		Funcionario func = em.find(Funcionario.class, 1);
		
		//alterar valores do funcionário
		func.setNome("joana");
		func.setSexo(Sexo.FEMININO);
		
		
		//Atualizar funcionário
		em.merge(func);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
		System.out.println("funcionário att");
		System.exit(0);
	}

}
