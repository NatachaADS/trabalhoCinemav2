package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.atendente;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.AtendenteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoAtendenteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        AtendenteRepository atendenteRepository = applicationContext.getBean(AtendenteRepository.class);

        Atendente atendente1 = new Atendente();
        atendente1.setNomeAtendente("Amanda Farias");
        atendente1.setMatriculaAtendente(100200300);

        Atendente atendente2 = new Atendente();
        atendente2.setNomeAtendente("Rafael V");
        atendente2.setMatriculaAtendente(100400500);

        Atendente atendente3 = new Atendente();
        atendente3.setNomeAtendente("Carol P");
        atendente3.setMatriculaAtendente(100600700);

        atendente1 = atendenteRepository.salvar(atendente1);
        atendente2 = atendenteRepository.salvar(atendente2);
        atendente3 = atendenteRepository.salvar(atendente3);

    }
}
