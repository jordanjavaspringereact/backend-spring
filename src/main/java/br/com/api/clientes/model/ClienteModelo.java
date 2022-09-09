package br.com.api.clientes.model;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Getter
@Setter

public class ClienteModelo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;
  private Long cpf;
  private String nome;
  private Long rg;
  private String dataNascimento;
  private String nomeMae;
  private Instant dataCadastro;

}
