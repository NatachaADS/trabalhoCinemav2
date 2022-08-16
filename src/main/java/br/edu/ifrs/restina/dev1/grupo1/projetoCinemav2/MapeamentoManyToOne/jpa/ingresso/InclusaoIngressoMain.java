package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.ingresso;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Ingresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.IngressoRepository;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SessaoRepository;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoIngressoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        IngressoRepository ingressoRepository = applicationContext.getBean(IngressoRepository.class);

        Ingresso ingresso1 = new Ingresso();
        ingresso1.setDataIngresso("10/08/2022");
        ingresso1.setHorarioIngresso("20:00");

        Ingresso ingresso2 = new Ingresso();
        ingresso2.setDataIngresso("12/08/2022");
        ingresso2.setHorarioIngresso("21:00");


        Ingresso ingresso3 = new Ingresso();
        ingresso3.setDataIngresso("15/08/2022");
        ingresso1.setHorarioIngresso("15:00");


        ingresso1 = ingressoRepository.salvar(ingresso1);
        ingresso2 = ingressoRepository.salvar(ingresso2);
        ingresso3 = ingressoRepository.salvar(ingresso3);

    }
}
