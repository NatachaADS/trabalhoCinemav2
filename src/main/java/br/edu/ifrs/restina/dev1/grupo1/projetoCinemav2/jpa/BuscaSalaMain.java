package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.entidade.Sala;

public class BuscaSalaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //application context gerencia os beans
        CadastroSala cadastroSala = applicationContext.getBean(CadastroSala.class);

        Sala sala = cadastroSala.buscar(1L);
        System.out.println("ID***" + sala.getNumeroSala());
    }
}
