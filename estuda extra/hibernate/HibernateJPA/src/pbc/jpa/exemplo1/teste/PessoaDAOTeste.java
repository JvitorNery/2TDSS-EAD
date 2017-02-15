package pbc.jpa.exemplo1.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;
import pbc.jpa.exemplo1.dao.PessoaDAO;
import pbc.jpa.exemplo1.modelo.Pessoa;

/**
 * Classe utilizada para testar os métodos do PessoaDAO.
 */
public class PessoaDAOTeste {
  public static void main(String[] args) throws Exception {
    Pessoa pessoa = new Pessoa();
    pessoa.setId(1L);
    pessoa.setNome("Rafael Sakurai");
    Calendar data = new GregorianCalendar();
    data.set(Calendar.YEAR, 1983);
    data.set(Calendar.MONTH, 11);
    data.set(Calendar.DAY_OF_MONTH, 26);
    pessoa.setDataNascimento(data.getTime());
    pessoa.setEmail("rafael.sakurai@metodista.br");

    PessoaDAO dao = new PessoaDAO();
    System.out.println("Salvando a pessoa: "
      + pessoa.getNome());
    pessoa = dao.salvar(pessoa);
/*
    pessoa.setNome("Rafael Guimarães Sakurai");
    pessoa = dao.salvar(pessoa);
    System.out.println("Alterando a pessoa: "
      + pessoa.getNome());*/

    Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
    System.out.println("Consultando: " + pessoa2.getNome());

    System.out.println("Removendo a pessoa: "
      + pessoa.getId());
    dao.excluir(pessoa.getId());
  }
}