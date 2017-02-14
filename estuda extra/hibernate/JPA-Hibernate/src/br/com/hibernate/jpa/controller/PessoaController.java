package br.com.hibernate.jpa.controller;

import br.com.hibernate.jpa.dao.PessoaDAO;
import br.com.hibernate.jpa.model.Pessoa;

public class PessoaController {
	
	public boolean salvar(Pessoa pessoa){
		PessoaDAO dao = new PessoaDAO();
		System.out.println("Salvando a pessoa: "
			      + pessoa.getNome());
		try {
			pessoa = dao.salvar(pessoa);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
			return false;
		}

	    System.out.println("Alterando a pessoa: "
	      + pessoa.getNome());
	    return true;
	}
	
	public boolean excluir(Pessoa pessoa){
		PessoaDAO dao = new PessoaDAO();
		try {
		Pessoa pessoa2 = dao.consultarPorId(pessoa.getId());
	    System.out.println("Consultando: " + pessoa2.getNome());
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		try{
	    
	    dao.excluir(pessoa.getId());
	    System.out.println("Removendo a pessoa: "
	  	      + pessoa.getId());
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
