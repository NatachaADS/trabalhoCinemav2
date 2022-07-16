package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa.cliente;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.ProjetoCinemav2Application;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Cliente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.ClienteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class InclusaoClienteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(ProjetoCinemav2Application.class)
                .web(WebApplicationType.NONE)
                .run(args);

        ClienteRepository clienteRepository = applicationContext.getBean(ClienteRepository.class);

        Cliente cliente1 = new Cliente();
        cliente1.setNomeCliente("Brenda Guimaraes");
        cliente1.setCpfCliente("000.000.000-00");

        Cliente cliente2 = new Cliente();
        cliente2.setNomeCliente("Daniel Rodrigues");
        cliente2.setCpfCliente("111.111.111-11");

        Cliente cliente3 = new Cliente();
        cliente3.setNomeCliente("Fernanda Nunes");
        cliente3.setCpfCliente("222.222.222-22");

        cliente1 = clienteRepository.salvar(cliente1);
        cliente2 = clienteRepository.salvar(cliente2);
        cliente3 = clienteRepository.salvar(cliente3);

    }
}
