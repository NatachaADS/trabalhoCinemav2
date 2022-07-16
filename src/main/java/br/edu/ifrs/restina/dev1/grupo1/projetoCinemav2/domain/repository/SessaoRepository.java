package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sessao;

import java.util.List;

public interface SessaoRepository {
    List<Sessao> listar();
    Sessao buscar(Long id);
    Sessao salvar(Sessao sessao);
    void remover(Sessao Sessao);
}
