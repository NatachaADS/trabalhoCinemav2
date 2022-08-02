package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class VendaIngresso {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horarioVendaIngresso;

    @ManyToOne // JPA - Associação de Muitos para um
    private Sessao sessao;

}
