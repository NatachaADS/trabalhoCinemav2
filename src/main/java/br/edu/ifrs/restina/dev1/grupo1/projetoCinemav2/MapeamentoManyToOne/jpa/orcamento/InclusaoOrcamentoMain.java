package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.orcamento;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.OrcamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoOrcamentoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        OrcamentoRepository orcamentoRepository = applicationContext.getBean(OrcamentoRepository.class);

        Orcamento orcamento1 = new Orcamento();
        orcamento1.setDiarioOrcamento(10000);
        orcamento1.setSemanalOrcamento(50000);
        orcamento1.setMensalOrcamento(500000);


        Orcamento orcamento2 = new Orcamento();
        orcamento2.setDiarioOrcamento(20000);
        orcamento2.setSemanalOrcamento(40000);
        orcamento2.setMensalOrcamento(400000);

        Orcamento orcamento3 = new Orcamento();
        orcamento3.setDiarioOrcamento(30000);
        orcamento3.setSemanalOrcamento(80000);
        orcamento3.setMensalOrcamento(800000);

        orcamento1 = orcamentoRepository.salvar(orcamento1);
        orcamento2 = orcamentoRepository.salvar(orcamento2);
        orcamento3 = orcamentoRepository.salvar(orcamento3);

    }
}
