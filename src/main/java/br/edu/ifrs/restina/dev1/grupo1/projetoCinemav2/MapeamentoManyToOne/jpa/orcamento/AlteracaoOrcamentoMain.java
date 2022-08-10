package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.orcamento;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.OrcamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoOrcamentoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        OrcamentoRepository orcamentoRepository = applicationContext.getBean(OrcamentoRepository.class);

        Orcamento orcamento = new Orcamento();
        orcamento.setId(1L);
        orcamento.setDiarioOrcamento(50);
        orcamento.setSemanalOrcamento(300);
        orcamento.setMensalOrcamento(9000);

        orcamentoRepository.salvar(orcamento);

    }
}
