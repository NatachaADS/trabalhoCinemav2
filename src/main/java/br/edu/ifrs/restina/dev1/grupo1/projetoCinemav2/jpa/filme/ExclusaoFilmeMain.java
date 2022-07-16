package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.filme;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.FilmeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class ExclusaoFilmeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FilmeRepository filmeRepository = applicationContext.getBean(FilmeRepository.class);

        Filme filme = new Filme();
        filme.setId(1L);

        filmeRepository.remover(filme);
    }
}
