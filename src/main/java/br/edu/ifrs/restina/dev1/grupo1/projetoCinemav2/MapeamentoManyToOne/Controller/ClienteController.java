package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Cliente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.ClienteRepository;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.service.CadastroClienteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private CadastroClienteService cadastroCliente;

    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Cliente> listar(){
        return clienteRepository.listar();

    }

//    @GetMapping("/{clienteId}")
//    public Cliente buscar(@PathVariable Long clienteId) {
//        return clienteRepository.buscar(clienteId);
//    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) {
        Cliente cliente = clienteRepository.buscar(clienteId);

        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar (@RequestBody Cliente cliente) {
        return cadastroCliente.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar (@PathVariable Long clienteId, @RequestBody Cliente cliente) {

        Cliente clenteAtual = clienteRepository.buscar(clienteId);

        if (clenteAtual != null) {
            BeanUtils.copyProperties(cliente, clenteAtual, "id");
            clienteRepository.salvar(clenteAtual);
            return ResponseEntity.ok(clenteAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Cliente> remover(@PathVariable Long clienteId) {
        try {
            Cliente cliente = clienteRepository.buscar(clienteId);

            if (cliente != null) {
                clienteRepository.remover(cliente);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
