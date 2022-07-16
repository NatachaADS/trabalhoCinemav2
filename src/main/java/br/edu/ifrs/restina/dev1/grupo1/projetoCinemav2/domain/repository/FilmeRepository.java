package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Filme;

import java.util.List;

public interface FilmeRepository {

    List<Filme> listar();

    Filme buscar(Long id);

    Filme salvar(Filme filme);

    void remover(Filme filme);
}
