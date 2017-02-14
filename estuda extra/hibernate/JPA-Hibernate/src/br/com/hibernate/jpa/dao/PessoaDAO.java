package br.com.hibernate.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.hibernate.jpa.model.Pessoa;

public class PessoaDAO {
	/**
	   * M�todo utilizado para obter o entity manager.
	 * @return 
	   * @return
	   */
	private EntityManager getEntityManager() {
	    EntityManagerFactory factory = null;
	    EntityManager entityManager = null;
	    try {
	      //Obt�m o factory a partir da unidade de persist�ncia.
	      factory = Persistence.createEntityManagerFactory
	        ("ExemplosJPAPU");
	      //Cria um entity manager.
	      entityManager = factory.createEntityManager();
	      //Fecha o factory para liberar os recursos utilizado.
	    } finally {
	      factory.close();
	    }
	    return entityManager;
	  }
	/**
	   * M�todo utilizado para salvar ou atualizar as 
	   * informa��es de uma pessoa.
	   * @param pessoa
	   * @return
	   * @throws java.lang.Exception
	   */
	public Pessoa salvar(Pessoa pessoa) throws Exception{
		
		EntityManager entityManager = getEntityManager();
		
		try{
			// Inicia uma transa��o com o banco de dados.
			
			entityManager.getTransaction().begin();
			System.out.println("Salvando pessoa");
			
			/* Verifica se a pessoa ainda n�o est� salva 
	        no banco de dados. */
			
			if(pessoa == null){
				entityManager.persist(pessoa);
			} else {
				pessoa = entityManager.merge(pessoa);
			}
			
			// Finaliza a transa��o.
			
			entityManager.getTransaction().commit();
			
		} finally{
			entityManager.close();
		}
		
		return pessoa;
	}
	
	/**
	   * M�todo que apaga a pessoa do banco de dados.
	   * @param id
	   */
	
	public void excluir(long id){
		
		EntityManager entityManager = getEntityManager();
		
		try{
			// Inicia uma transa��o com o banco de dados.
			
			entityManager.getTransaction().begin();
			System.out.println("Salvando pessoa");
			/* Consulta a pessoa na base de dados atrav�s 
	        do seu ID. */
			Pessoa pessoa = consultarPorId(id);
		      System.out.println("Excluindo a pessoa: " 
		        + pessoa.getNome());
		      
		   // Remove a pessoa da base de dados.
		   entityManager.remove(pessoa);
		   // Finaliza a transa��o.
		   entityManager.getTransaction().commit();   
		} finally {
			entityManager.close();
		}
		
	}
	
	/**
	   * Consulta o pessoa pelo ID.
	   * @param id
	   * @return o objeto Pessoa.
	   */
	
	public Pessoa consultarPorId(long id){
		
		EntityManager entityManager = getEntityManager();
		Pessoa pessoa = null;
		
		try{
			pessoa = entityManager.find(pessoa.getClass(), id);
		} finally {
			entityManager.close();
		}
		return pessoa;
	}
	
	
	
	
}
