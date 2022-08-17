package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /filmes HTTP/1.1

//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/filmes")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class FilmeController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private FilmeRepository filmeRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<Filme> listar(){
        return filmeRepository.listar();
    }

    @GetMapping("/{clienteId}")
    public Filme buscar(@PathVariable Long filmeId) {
        return filmeRepository.buscar(filmeId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme adicionar (@RequestBody Filme filme) {
        return filmeRepository.salvar(filme);
    }
}
