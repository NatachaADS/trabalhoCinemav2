package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.sala;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sala;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.SalaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaSalaMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        SalaRepository salaRepository = applicationContext.getBean(SalaRepository.class);

        List<Sala> todasSalas = salaRepository.listar();

        for (Sala sala : todasSalas) {
            System.out.println(sala.getNumeroSala());
        }
    }
}
