package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Ingresso;

import java.util.List;

public interface IngressoRepository {

    List<Ingresso> listar();

    Ingresso buscar(Long id);

    Ingresso salvar(Ingresso ingresso);

    void remover(Ingresso ingresso);
}
