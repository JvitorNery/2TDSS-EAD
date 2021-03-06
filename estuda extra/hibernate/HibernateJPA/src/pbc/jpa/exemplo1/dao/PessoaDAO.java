package pbc.jpa.exemplo1.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import pbc.jpa.exemplo1.modelo.Pessoa;

/**
 * Classe utilizada para fazer realizar as opera��es de 
 * banco de dados sobre a entity Pessoa.
 */
public class PessoaDAO {
  /**
   * M�todo utilizado para obter o entity manager.
   * @return
   */
  private EntityManager getEntityManager() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
    EntityManager entityManager = factory.createEntityManager();
    try {
      //Obt�m o factory a partir da unidade de persist�ncia.
      //factory = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
      
      //Cria um entity manager.
      //entityManager = factory.createEntityManager();
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
  public Pessoa salvar(Pessoa pessoa) throws Exception {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transa��o com o banco de dados.
    	
      entityManager.getTransaction().begin();
      System.out.println("Salvando a pessoa.");
      /* Verifica se a pessoa ainda n�o est� salva 
        no banco de dados. */
      if(pessoa.getId() == null) {
        entityManager.persist(pessoa);
      } else {
        pessoa = entityManager.merge(pessoa);
      }
      // Finaliza a transa��o.
      entityManager.getTransaction().commit();
    } finally {
      entityManager.close();
    }
    return pessoa;
  }

  /**
   * M�todo que apaga a pessoa do banco de dados.
   * @param id
   */
  public void excluir(Long id) {
    EntityManager entityManager = getEntityManager();
    try {
      // Inicia uma transa��o com o banco de dados.
      entityManager.getTransaction().begin();
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
  public Pessoa consultarPorId(Long id) {
    EntityManager entityManager = getEntityManager();
    Pessoa pessoa = null;
    try {
      pessoa = entityManager.find(Pessoa.class, id);
    } finally {
      entityManager.close();
    }
    return pessoa;
  }
}