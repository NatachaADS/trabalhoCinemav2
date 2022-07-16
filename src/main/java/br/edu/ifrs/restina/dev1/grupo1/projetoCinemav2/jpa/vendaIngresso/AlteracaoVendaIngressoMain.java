package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.vendaIngresso;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.VendaIngressoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoVendaIngressoMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        VendaIngressoRepository vendaIngressoRepository = applicationContext.getBean(VendaIngressoRepository.class);

        VendaIngresso vendaIngresso = new VendaIngresso();
        vendaIngresso.setId(1L);
        vendaIngresso.setHorarioVendaIngresso("15:33");

        vendaIngressoRepository.salvar(vendaIngresso);

    }
}
