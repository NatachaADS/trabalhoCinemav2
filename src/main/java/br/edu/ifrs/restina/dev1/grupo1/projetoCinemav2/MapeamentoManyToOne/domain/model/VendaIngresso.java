package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

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

    @Column(nullable = false)
    private String horarioVendaIngresso;

// Tem uma relação de sessão com ingresso que elimina a necessidade com sessão e vendaIngresso
//    @ManyToOne // JPA - Associação de Muitos para um
//    @JoinColumn(nullable = false)
//    private Sessao sessao;

}
