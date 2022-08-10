package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Cliente;

import java.util.List;

public interface ClienteRepository {

    List<Cliente> listar();

    Cliente buscar(Long id);

    Cliente salvar(Cliente cliente);

    void remover(Cliente cliente);
}
