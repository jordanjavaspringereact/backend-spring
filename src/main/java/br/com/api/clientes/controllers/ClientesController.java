package br.com.api.clientes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.clientes.model.ClienteModelo;
import br.com.api.clientes.model.RespostaModelo;
import br.com.api.clientes.service.ClientesService;

@RestController
@CrossOrigin(origins = "*")
public class ClientesController {

  @Autowired
  private ClientesService ps;

  @DeleteMapping("/remover/{codigo}")
  public ResponseEntity<RespostaModelo> remover(@PathVariable long codigo) {

    return ps.remover(codigo);

  }

  @PutMapping("/alterar")
  public ResponseEntity<?> alterar(@RequestBody ClienteModelo pm) {
    return ps.cadastrarAlterar(pm, "alterar");
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ClienteModelo pm) {
    return ps.cadastrarAlterar(pm, "cadastrar");
  }

  @GetMapping("/listar")
  public Iterable<ClienteModelo> listar() {
    return ps.listar();
  }

  @GetMapping("/")
  public String rota() {
    return "Api de Clientes funcionando!";
  }

}
