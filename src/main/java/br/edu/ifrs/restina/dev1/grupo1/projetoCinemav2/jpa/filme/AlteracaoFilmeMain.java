package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.filme;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.FilmeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoFilmeMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FilmeRepository filmeRepository = applicationContext.getBean(FilmeRepository.class);

        Filme filme = new Filme();
        filme.setId(1L);
        filme.setTituloFilme("Corra!");
        filme.setDuracaoFilme("104 minutos");
        filme.setClassificacaoFilme("14 Anos");
        filme.setGeneroFilme("Horror/Terror, Mistério");
        filme.setSinopseFilme("Chris é um jovem negro que está prestes a conhecer a família de sua namorada, " +
                "a caucasiana Rose. A princípio, ele acredita que o comportamento excessivamente amoroso por " +
                "parte da família dela é uma tentativa de lidar com o relacionamento de Rose com um rapaz de sua " +
                "etnia, mas, com o tempo, ele percebe que a família esconde algo muito mais perturbador.");

        filmeRepository.salvar(filme);

    }
}
