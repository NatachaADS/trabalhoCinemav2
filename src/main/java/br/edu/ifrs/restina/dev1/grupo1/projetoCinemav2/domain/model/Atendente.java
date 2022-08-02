package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Atendente {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeAtendente;

    private int matriculaAtendente;

    @ManyToOne // JPA - Associação de Muitos para um
    private Cliente cliente;

    @ManyToOne // JPA - Associação de Muitos para um
    private Orcamento orcamento;

    @ManyToMany // JPA - Associação de Muitos para Muitos
    private List<VendaIngresso> vendaIngressos;
}
