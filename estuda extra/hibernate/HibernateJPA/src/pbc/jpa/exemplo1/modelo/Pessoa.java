package pbc.jpa.exemplo1.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe utilizada para representar uma pessoa.
 */
@Entity
@SequenceGenerator(name="PES_SEQ", 
  sequenceName="PESSOA_SEQ", allocationSize=1,
  initialValue=1)
public class Pessoa implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, 
    generator="PES_SEQ")
  private Long id;
  @Column(nullable = false)
  private String nome;
  @Temporal(TemporalType.DATE)
  @Column(name = "dataNasc", nullable = false)
  private Date dataNascimento;
  private String email;

  public Date getDataNascimento() {
    return dataNascimento;
  }
  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

  public String getEmail() { return email; }
  public void setEmail(String email) {
    this.email = email;
  }

  public Long getId() { return id; }
  public void setId(Long id) { this.id = id; }

  public String getNome() { return nome; }
  public void setNome(String nome) { this.nome = nome; }
}