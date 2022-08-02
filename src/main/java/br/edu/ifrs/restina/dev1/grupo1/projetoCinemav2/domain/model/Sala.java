package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model;

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

    private String numeroSala;
    private int qntAssentos;

    //@OneToOne
    //@JoinColumn(unique = true)
    //private Sessao sessao;
}
