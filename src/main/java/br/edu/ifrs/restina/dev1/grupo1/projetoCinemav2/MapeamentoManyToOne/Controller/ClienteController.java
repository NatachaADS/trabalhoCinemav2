package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Cliente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /clientes HTTP/1.1

//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/clientes")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class ClienteController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private ClienteRepository clienteRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Cliente> listar(){
        return clienteRepository.listar();

    }

    @GetMapping("/{clienteId}")
    public Cliente buscar(@PathVariable Long clienteId) {
        return clienteRepository.buscar(clienteId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar (@RequestBody Cliente cliente) {
        return clienteRepository.salvar(cliente);
    }
}
