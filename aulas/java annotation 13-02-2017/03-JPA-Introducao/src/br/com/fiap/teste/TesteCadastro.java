package br.com.fiap.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.entity.Funcionario;
import br.com.fiap.entity.Sexo;

public class TesteCadastro {

	public static void main(String[] args) {
		//Cadastrar funcion�rio
		
		Funcionario func = new Funcionario(0,"Gondo", new GregorianCalendar(200,Calendar.JUNE,12),
				Calendar.getInstance(),0,null,Sexo.MASCULINO);
		
		//obter uma inst�ncia
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
		EntityManager em = fabrica.createEntityManager();
		
		//chamar m�todo
		em.persist(func);
		
		//iniciar e finazliar transa��o
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		fabrica.close();
		
		//sucesso
		System.out.println("funcin�rio cadastrado");
		System.exit(0);
		
	}

}
