package br.com.hibernate.jpa.model;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="seq_Pessoa",sequenceName="PESSOA_SEQ", allocationSize=1)
public class Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_Pessoa")
	private long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "DATANASC", nullable = false)
	private Calendar nascimeno;
	
	@Column(name="EMAIL",nullable = false)
	private String email;

	public Pessoa(long id, String nome, Calendar nascimeno, String email) {
		super();
		this.id = id;
		this.nome = nome;
		this.nascimeno = nascimeno;
		this.email = email;
	}
	public Pessoa() {}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getNascimeno() {
		return nascimeno;
	}

	public void setNascimeno(Calendar nascimeno) {
		this.nascimeno = nascimeno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
