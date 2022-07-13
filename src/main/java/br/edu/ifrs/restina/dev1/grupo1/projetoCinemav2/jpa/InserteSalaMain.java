package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.entidade.Sala;

public class InserteSalaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);

		CadastroSala cadastroSala = applicationContext.getBean(CadastroSala.class);
		
		Sala sala1 = new Sala();
		sala1.setNumeroSala("Sala Teste1");
		sala1.setQntAssentos(100);
		
		Sala sala2 = new Sala();
		sala2.setNumeroSala("Sala Teste2");
		sala2.setQntAssentos(200);
		
		Sala sala3 = new Sala();
		sala3.setNumeroSala("Sala Teste3");
		sala3.setQntAssentos(300);
		
		cadastroSala.adicionar(sala1);
		cadastroSala.adicionar(sala2);
		cadastroSala.adicionar(sala3);
		//System.out.println(sala3.getNumeroSala());
    }
    
}