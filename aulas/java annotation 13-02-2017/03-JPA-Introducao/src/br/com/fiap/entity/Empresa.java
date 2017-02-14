package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_EMPRESA")
@SequenceGenerator(name="Seq_Empresa",sequenceName="SQ_TB_EMPRESA",allocationSize=1)
public class Empresa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SQ_TB_EMPRESA")
	@Column(name="CD_EMPRESA")
	private int codigo;
	
	@Column(name="NM_EMPRESA",length=150)
	private String nome;
	
	@Column(name="NR_CNPJ",length=16)
	private int cnpj;
	
	@Column(name="DT_FUNDACAO")
	@Temporal(TemporalType.DATE)
	private Calendar fundacao;
	
	@Column(name="DS_ENDERECO")
	private String endereco;
	
	@Column(name="VL_FATURAMENTO")
	private double faturamento;
	
	@Column(name="FL_LOGO")
	private byte[] logo;
	
	@Column(name="NR_TELEFONE",length=9)
	private String telefone;
	
	@Column(name="DS_status")
	private Status status;


	public Empresa(int codigo, String nome, int cnpj, Calendar fundacao, String endereco, double faturamento,
			byte[] logo, String telefone, Status status) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.cnpj = cnpj;
		this.fundacao = fundacao;
		this.endereco = endereco;
		this.faturamento = faturamento;
		this.logo = logo;
		this.telefone = telefone;
		this.status = status;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCnpj() {
		return cnpj;
	}

	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}

	public Calendar getFundacao() {
		return fundacao;
	}

	public void setFundacao(Calendar fundacao) {
		this.fundacao = fundacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public double getFaturamento() {
		return faturamento;
	}

	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
}
