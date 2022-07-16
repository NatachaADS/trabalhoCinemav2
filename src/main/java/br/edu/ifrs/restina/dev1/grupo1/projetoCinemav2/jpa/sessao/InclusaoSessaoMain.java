package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.sessao;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.SessaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoSessaoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        SessaoRepository sessaoRepository = applicationContext.getBean(SessaoRepository.class);

        Sessao sessao1 = new Sessao();
        sessao1.setHorarioSessao("20:00");

        Sessao sessao2 = new Sessao();
        sessao2.setHorarioSessao("14:00");

        Sessao sessao3 = new Sessao();
        sessao3.setHorarioSessao("10:00");

        sessao1 = sessaoRepository.salvar(sessao1);
        sessao2 = sessaoRepository.salvar(sessao2);
        sessao3 = sessaoRepository.salvar(sessao3);

    }
}
