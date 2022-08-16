package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Ingresso {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String dataIngresso;

    @Column(nullable = false)
    private String horarioIngresso;

    @ManyToOne // JPA - Associação de Muitos para um
    @JoinColumn(nullable = false) //
    private VendaIngresso vendaIngresso;

}
