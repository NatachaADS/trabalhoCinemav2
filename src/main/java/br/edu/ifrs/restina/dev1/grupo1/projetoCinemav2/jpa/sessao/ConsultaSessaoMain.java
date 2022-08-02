package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.sessao;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.SessaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaSessaoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        SessaoRepository sessaoRepository = applicationContext.getBean(SessaoRepository.class);

        List<Sessao> todasSessoes = sessaoRepository.listar();

        for (Sessao sessao : todasSessoes) {
            //System.out.println(sessao.getHorarioSessao());
            //System.out.printf("%s - %s \n", sessao.getHorarioSessao(), sessao.getFilme().getTituloFilme());
            System.out.printf("%s - %s - %s\n", sessao.getHorarioSessao(), sessao.getSala().getNumeroSala(),
                    sessao.getFilme().getTituloFilme());
        }
    }
}
