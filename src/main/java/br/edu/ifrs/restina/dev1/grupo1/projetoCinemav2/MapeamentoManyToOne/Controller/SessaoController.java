package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SessaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /sessoes HTTP/1.1

//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/sessoes")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class SessaoController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private SessaoRepository sessaoRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Sessao> listar(){
        return sessaoRepository.listar();
    }

    @GetMapping("/{sessaoId}")
    public Sessao buscar(@PathVariable Long sessaoId) {
        return sessaoRepository.buscar(sessaoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sessao adicionar (@RequestBody Sessao sessao) {
        return sessaoRepository.salvar(sessao);
    }
}
