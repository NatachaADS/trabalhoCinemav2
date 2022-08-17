package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.OrcamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /orcamentos HTTP/1.1

//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/orcamentos")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class OrcamentoController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private OrcamentoRepository orcamentoRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Orcamento> listar(){
        return orcamentoRepository.listar();
    }

    @GetMapping("/{orcamentoId}")
    public Orcamento buscar(@PathVariable Long orcamentoId) {
        return orcamentoRepository.buscar(orcamentoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orcamento adicionar (@RequestBody Orcamento orcamento) {
        return orcamentoRepository.salvar(orcamento);
    }
}
