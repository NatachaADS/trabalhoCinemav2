package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.orcamento;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.OrcamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaOrcamentoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);


        OrcamentoRepository orcamentoRepository = applicationContext.getBean(OrcamentoRepository.class);

        Orcamento orcamento = orcamentoRepository.buscar(1L);

        System.out.println(orcamento.getDiarioOrcamento());
    }
}
