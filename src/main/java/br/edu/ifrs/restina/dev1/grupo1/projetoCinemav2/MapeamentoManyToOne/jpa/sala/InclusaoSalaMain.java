package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.sala;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sala;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SalaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoSalaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        SalaRepository salaRepository = applicationContext.getBean(SalaRepository.class);

        Sala sala1 = new Sala();
        sala1.setNumeroSala("A10");
        sala1.setQntAssentos(110);

        Sala sala2 = new Sala();
        sala2.setNumeroSala("A20");
        sala2.setQntAssentos(220);

        Sala sala3 = new Sala();
        sala3.setNumeroSala("A30");
        sala3.setQntAssentos(330);

        sala1 = salaRepository.salvar(sala1);
        sala2 = salaRepository.salvar(sala2);
        sala3 = salaRepository.salvar(sala3);

    }
}
