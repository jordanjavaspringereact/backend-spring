package br.com.api.clientes.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.api.clientes.model.ClienteModelo;
import br.com.api.clientes.model.RespostaModelo;
import br.com.api.clientes.repositorio.ClientesRepositorio;

@Service
public class ClientesService {

  @Autowired
  private ClientesRepositorio pr;

  @Autowired
  private RespostaModelo rm;

  // method para listar todos os clientes

  public Iterable<ClienteModelo> listar() {
    return pr.findAll();
  }

  // metodo para cadastrar clientes
  public ResponseEntity<?> cadastrarAlterar(ClienteModelo pm, String acao) {

    if (pm.getNome().equals("")) {
      rm.setMensagem("O nome do cliente eh obrigatorio");

      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

    } else if (pm.getCpf().equals("")) {
      rm.setMensagem("o campo cpf eh obrigatorio!");
      return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);

    } else {
      if (acao.equals("cadastrar")) {
        return new ResponseEntity<ClienteModelo>(pr.save(pm), HttpStatus.CREATED);

      } else {
        return new ResponseEntity<ClienteModelo>(pr.save(pm), HttpStatus.OK);
      }
    }

  }

  // metodo para remover cliente

  public ResponseEntity<RespostaModelo> remover(long codigo) {

    pr.deleteById(codigo);

    rm.setMensagem("o produto foi removido com sucesso");
    return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
  }

}
