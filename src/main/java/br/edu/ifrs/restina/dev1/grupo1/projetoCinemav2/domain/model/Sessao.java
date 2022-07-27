package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Sessao {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String horarioSessao;

  //  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  //  private LocalDateTime localDateTime;


}
