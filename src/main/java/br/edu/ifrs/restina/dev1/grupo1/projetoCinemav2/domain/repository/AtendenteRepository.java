package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Atendente;

import java.util.List;

public interface AtendenteRepository {

    List<Atendente> listar();

    Atendente buscar(Long id);

    Atendente salvar(Atendente atendente);

    void remover(Atendente atendente);
}
