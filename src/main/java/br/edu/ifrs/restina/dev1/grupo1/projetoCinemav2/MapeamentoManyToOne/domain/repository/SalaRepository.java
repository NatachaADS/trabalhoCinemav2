package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sala;

import java.util.List;

public interface SalaRepository {
    List<Sala> listar();
    Sala buscar(Long id);
    Sala salvar(Sala sala);
    void remover(Sala sala);
}
