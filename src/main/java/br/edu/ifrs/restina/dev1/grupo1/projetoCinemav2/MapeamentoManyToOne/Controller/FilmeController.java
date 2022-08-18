package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.FilmeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{filmeId}")
//    public Filme buscar(@PathVariable Long filmeId) {
//        return filmeRepository.buscar(filmeId);
//    }

    @GetMapping("/{filmeId}")
    public ResponseEntity<Filme> buscar(@PathVariable Long filmeId) {
        Filme filme = filmeRepository.buscar(filmeId);

        if (filme != null) {
            return ResponseEntity.ok(filme);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Filme adicionar (@RequestBody Filme filme) {
        return filmeRepository.salvar(filme);
    }

    @PutMapping("/{filmeId}")
    public ResponseEntity<Filme> atualizar (@PathVariable Long filmeId, @RequestBody Filme filme) {

        Filme filmeAtual = filmeRepository.buscar(filmeId);

        if (filmeAtual != null) {
            BeanUtils.copyProperties(filme, filmeAtual, "id");
            filmeRepository.salvar(filmeAtual);
            return ResponseEntity.ok(filmeAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{filmeId}")
    public ResponseEntity<Filme> remover(@PathVariable Long filmeId) {
        try {
            Filme filme = filmeRepository.buscar(filmeId);

            if (filme != null) {
                filmeRepository.remover(filme);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
