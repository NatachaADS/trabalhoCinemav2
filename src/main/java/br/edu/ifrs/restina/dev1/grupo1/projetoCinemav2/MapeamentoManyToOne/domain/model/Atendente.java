package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

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

    @Column(nullable = false)
    private String nomeAtendente;

    private int matriculaAtendente;

    @ManyToOne // JPA - Associação de Muitos para um
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne // JPA - Associação de Muitos para um
    @JoinColumn(nullable = false) //
    private Orcamento orcamento;

    @ManyToOne // JPA - Associação de Muitos para um
    @JoinColumn(nullable = false) //
    private VendaIngresso vendaIngresso;

 //   @ManyToMany // JPA - Associação de Muitos para Muitos
 //   @JoinColumn(nullable = false)
 //   private List<VendaIngresso> vendaIngressos;
}
