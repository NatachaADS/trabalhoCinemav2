package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Filme {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tituloFilme;

    @Column(nullable = false)
    private String duracaoFilme;

    @Column(nullable = false)
    private String classificacaoFilme;

    @Column(nullable = false)
    private String generoFilme;

    @Column(length = 2000,nullable = false)
    private String sinopseFilme;

}
