package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SessaoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{sessaoId}")
//    public Sessao buscar(@PathVariable Long sessaoId) {
//        return sessaoRepository.buscar(sessaoId);
//    }

    @GetMapping("/{sessaoId}")
    public ResponseEntity<Sessao> buscar(@PathVariable Long sessaoId) {
        Sessao sessao = sessaoRepository.buscar(sessaoId);

        if (sessao != null) {
            return ResponseEntity.ok(sessao);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sessao adicionar (@RequestBody Sessao sessao) {
        return sessaoRepository.salvar(sessao);
    }

    @PutMapping("/{sessaoId}")
    public ResponseEntity<Sessao> atualizar (@PathVariable Long sessaoId, @RequestBody Sessao sessao) {

        Sessao sessaoAtual = sessaoRepository.buscar(sessaoId);

        if (sessaoAtual != null) {
            BeanUtils.copyProperties(sessao, sessaoAtual, "id");
            sessaoRepository.salvar(sessaoAtual);
            return ResponseEntity.ok(sessaoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{sessaoId}")
    public ResponseEntity<Sessao> remover(@PathVariable Long sessaoId) {
        try {
            Sessao sessao = sessaoRepository.buscar(sessaoId);

            if (sessao != null) {
                sessaoRepository.remover(sessao);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
