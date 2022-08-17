package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sala;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /salas HTTP/1.1

//4 component do spring
//@Controller


//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/salas")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class SalaController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private SalaRepository salaRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Sala> listar(){
        return salaRepository.listar();
    }

    @GetMapping("/{salaId}")
    public Sala buscar(@PathVariable Long salaId) {
        return salaRepository.buscar(salaId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sala adicionar (@RequestBody Sala sala) {
        return salaRepository.salvar(sala);
    }
}
