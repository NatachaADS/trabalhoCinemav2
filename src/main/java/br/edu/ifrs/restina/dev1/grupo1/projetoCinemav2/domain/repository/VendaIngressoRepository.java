package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.VendaIngresso;

import java.util.List;

public interface VendaIngressoRepository {

    List<VendaIngresso> listar();

    VendaIngresso buscar(Long id);

    VendaIngresso salvar(VendaIngresso vendaIngresso);

    void remover(VendaIngresso vendaIngresso);
}
