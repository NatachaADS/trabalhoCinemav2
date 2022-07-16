package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.sessao;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.SessaoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoSessaoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        SessaoRepository sessaoRepository = applicationContext.getBean(SessaoRepository.class);

        Sessao sessao = new Sessao();
        sessao.setId(1L);
        sessao.setHorarioSessao("17:00");;

        sessaoRepository.salvar(sessao);

    }
}
