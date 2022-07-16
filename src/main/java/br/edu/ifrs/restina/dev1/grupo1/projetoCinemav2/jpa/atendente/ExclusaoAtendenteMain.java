package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.atendente;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.AtendenteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoAtendenteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        AtendenteRepository atendenteRepository = applicationContext.getBean(AtendenteRepository.class);

        Atendente atendente = new Atendente();
        atendente.setId(1L);

        atendenteRepository.remover(atendente);
    }
}
