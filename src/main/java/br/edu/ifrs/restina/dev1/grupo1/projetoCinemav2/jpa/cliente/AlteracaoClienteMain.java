package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.cliente;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Cliente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.ClienteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoClienteMain {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ClienteRepository clienteRepository = applicationContext.getBean(ClienteRepository.class);

        Cliente cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNomeCliente("Emanuell Moraes");
        cliente.setCpfCliente("333.333.333-33");

        clienteRepository.salvar(cliente);

    }
}
