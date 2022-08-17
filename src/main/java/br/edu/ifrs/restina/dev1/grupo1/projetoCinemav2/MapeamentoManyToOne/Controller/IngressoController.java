package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Ingresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.IngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /ingressos HTTP/1.1

//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/ingressos")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class IngressoController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private IngressoRepository ingressoRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Ingresso> listar(){
        return ingressoRepository.listar();
    }

    @GetMapping("/{ingressoId}")
    public Ingresso buscar(@PathVariable Long ingressoId) {
        return ingressoRepository.buscar(ingressoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingresso adicionar (@RequestBody Ingresso ingresso) {
        return ingressoRepository.salvar(ingresso);
    }
}
