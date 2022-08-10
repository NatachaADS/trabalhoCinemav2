package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;

import java.util.List;

public interface OrcamentoRepository {

    List<Orcamento> listar();

    Orcamento buscar(Long id);

    Orcamento salvar(Orcamento orcamento);

    void remover(Orcamento orcamento);
}
