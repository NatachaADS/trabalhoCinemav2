package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Sala {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    // Id auto increment
    private Long id;

    @Column(nullable = false)
    private String numeroSala;

    @Column(nullable = false)
    private int qntAssentos;

    //@OneToOne
    //@JoinColumn(unique = true)
    //private Sessao sessao;
}
