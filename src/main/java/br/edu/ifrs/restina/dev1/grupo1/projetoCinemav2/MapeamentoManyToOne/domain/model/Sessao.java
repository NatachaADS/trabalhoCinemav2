package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Sessao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String horarioSessao;

  //  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  //  private LocalDateTime localDateTime;

    @OneToOne // JPA - Associação de UM para UM
    @JoinColumn(unique = true,nullable = false)
    private Sala sala;

    @ManyToOne // JPA - Associação de Muitos para um
    @JoinColumn(nullable = false)
    private Ingresso ingresso;

}
