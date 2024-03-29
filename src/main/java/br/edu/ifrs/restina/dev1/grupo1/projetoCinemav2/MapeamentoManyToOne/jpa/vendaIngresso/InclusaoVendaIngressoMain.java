package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.jpa.vendaIngresso;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.VendaIngressoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoVendaIngressoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        VendaIngressoRepository vendaIngressoRepository = applicationContext.getBean(VendaIngressoRepository.class);

        VendaIngresso vendaIngresso1 = new VendaIngresso();
        vendaIngresso1.setHorarioVendaIngresso("22:55");

        VendaIngresso vendaIngresso2 = new VendaIngresso();
        vendaIngresso2.setHorarioVendaIngresso("07:45");

        VendaIngresso vendaIngresso3 = new VendaIngresso();
        vendaIngresso3.setHorarioVendaIngresso("20:15");

        vendaIngresso1 = vendaIngressoRepository.salvar(vendaIngresso1);
        vendaIngresso2 = vendaIngressoRepository.salvar(vendaIngresso2);
        vendaIngresso3 = vendaIngressoRepository.salvar(vendaIngresso3);

    }
}
