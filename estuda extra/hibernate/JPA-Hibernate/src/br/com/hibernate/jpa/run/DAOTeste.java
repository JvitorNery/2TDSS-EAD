package br.com.hibernate.jpa.run;

import java.util.Calendar;
import java.util.GregorianCalendar;

import br.com.hibernate.jpa.controller.PessoaController;
import br.com.hibernate.jpa.dao.PessoaDAO;
import br.com.hibernate.jpa.model.Pessoa;

public class DAOTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Pessoa pessoa = new Pessoa(1L, "Shintaro Ryoushi", new GregorianCalendar(5,Calendar.JUNE,1995), "teste@email.com");
			    
				//acessar dao no controller
				PessoaController  pc = new PessoaController();
				pc.salvar(pessoa);
				
				pc.excluir(pessoa);
				
				//acessar dao na camada de aplicação
				
				/*PessoaDAO dao = new PessoaDAO();
				System.out.println("Salvando a pessoa: "
					      + pessoa.getNome());
				try {
					pessoa = dao.salvar(pessoa);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			    System.out.println("Alterando a pessoa: "
			      + pessoa.getNome());
			    */
			    
				/*
			    Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
			    System.out.println("Consultando: " + pessoa2.getNome());

			    System.out.println("Removendo a pessoa: "
			      + pessoa.getId());
			    dao.excluir(pessoa.getId());*/
				
				
			}
	

}
