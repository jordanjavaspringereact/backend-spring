package br.com.api.clientes.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.clientes.model.ClienteModelo;

@Repository

public interface ClientesRepositorio extends CrudRepository<ClienteModelo, Long> {

}
