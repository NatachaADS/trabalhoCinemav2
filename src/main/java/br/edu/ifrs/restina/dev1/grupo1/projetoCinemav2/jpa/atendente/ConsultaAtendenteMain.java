package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.atendente;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.AtendenteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaAtendenteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        AtendenteRepository atendenteRepository = applicationContext.getBean(AtendenteRepository.class);

        List<Atendente> todosAtendentes = atendenteRepository.listar();

        for (Atendente atendente : todosAtendentes) {
            //System.out.printf("%s - %d\n", atendente.getNomeAtendente(), atendente.getMatriculaAtendente());
            System.out.printf("%s - %d - %s\n", atendente.getNomeAtendente(), atendente.getMatriculaAtendente(),
                    atendente.getCliente().getNomeCliente());
        }
    }
}
