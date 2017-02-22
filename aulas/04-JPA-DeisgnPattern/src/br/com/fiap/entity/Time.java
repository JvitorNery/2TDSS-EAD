package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_TIME")
@SequenceGenerator(name="seqTime",sequenceName="SQ_TB_TIME",allocationSize=1)public class Time {
	@Id
	@Column(name="CD_TIME")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqTime")
	private int id;
	@Column(name="NM_TIME")
	private String nome;
	@Column(name="NM_ESTADIO")
	private String estadio;
	@Column(name="DT_FUNDACAO")
	@Temporal(TemporalType.DATE)
	private Calendar dataFundacao;
	@Lob
	@Column(name="FL_ESCUDO")
	private byte[] escudo;
	public Time(int id, String nome, String estadio, Calendar dataFundacao, byte[] escudo) {
		super();
		this.id = id;
		this.nome = nome;
		this.estadio = estadio;
		this.dataFundacao = dataFundacao;
		this.escudo = escudo;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	public Calendar getDataFundacao() {
		return dataFundacao;
	}
	public void setDataFundacao(Calendar dataFundacao) {
		this.dataFundacao = dataFundacao;
	}
	public byte[] getEscudo() {
		return escudo;
	}
	public void setEscudo(byte[] escudo) {
		this.escudo = escudo;
	}
}
