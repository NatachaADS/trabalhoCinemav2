package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.filme;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.FilmeRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoFilmeMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        FilmeRepository filmeRepository = applicationContext.getBean(FilmeRepository.class);

        Filme filme1 = new Filme();
        filme1.setTituloFilme("Encanto");
        filme1.setDuracaoFilme("109 minutos");
        filme1.setClassificacaoFilme("L - Livre para todos os públicos");
        filme1.setGeneroFilme("Animação, Família, Fantasia");
        filme1.setSinopseFilme("Encanto é um abraço no coração de muitas formas diferentes - " +
                "da casa que ganha vida para proteger suas raízes à uma grande história sobre família e " +
                "autopercepção, A nova animação da Disney arremata um trama doce com a trilha sonora inspirada " +
                "do indicado ao Oscar Lin-Manuel Miranda, responsável pela trilha sonora de Moana.");

        Filme filme2 = new Filme();
        filme2.setTituloFilme("A Caminho da Lua");
        filme2.setDuracaoFilme("100 minutos");
        filme2.setClassificacaoFilme("L - Livre para todos os públicos");
        filme2.setGeneroFilme("Animação, Aventura, Comédia, Família");
        filme2.setSinopseFilme("Na animação da Netflix, A Caminho da Lua, depois de ter finalizado a construção " +
                "de uma engenhosa nave espacial, uma garota embarca para a lua para provar ao seu pai a existência " +
                "de uma deusa mística que habitaria no astro.");

        Filme filme3 = new Filme();
        filme3.setTituloFilme("Viva - A Vida é uma Festa");
        filme3.setDuracaoFilme("1h 45min");
        filme3.setClassificacaoFilme("L - Livre para todos os públicos");
        filme3.setGeneroFilme("Animação, Família, Fantasia");
        filme3.setSinopseFilme("Um menino de 12 anos, na tentativa de ser um músico famoso, enfrenta a desaprovação " +
                "de sua família, acabando por se envolver em um mistério de 100 anos.");

        filme1 = filmeRepository.salvar(filme1);
        filme2 = filmeRepository.salvar(filme2);
        filme3 = filmeRepository.salvar(filme3);

    }
}
