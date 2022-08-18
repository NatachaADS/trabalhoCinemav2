package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Ingresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.IngressoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{ingressoId}")
//    public Ingresso buscar(@PathVariable Long ingressoId) {
//        return ingressoRepository.buscar(ingressoId);
//    }

    @GetMapping("/{ingressoId}")
    public ResponseEntity<Ingresso> buscar(@PathVariable Long ingressoId) {
        Ingresso ingresso = ingressoRepository.buscar(ingressoId);

        if (ingresso != null) {
            return ResponseEntity.ok(ingresso);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingresso adicionar (@RequestBody Ingresso ingresso) {
        return ingressoRepository.salvar(ingresso);
    }

    @PutMapping("/{ingressoId}")
    public ResponseEntity<Ingresso> atualizar (@PathVariable Long ingressoId, @RequestBody Ingresso ingresso) {

        Ingresso ingressoAtual = ingressoRepository.buscar(ingressoId);

        if (ingressoAtual != null) {
            BeanUtils.copyProperties(ingresso, ingressoAtual, "id");
            ingressoRepository.salvar(ingressoAtual);
            return ResponseEntity.ok(ingressoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{ingressoId}")
    public ResponseEntity<Ingresso> remover(@PathVariable Long ingressoId) {
        try {
            Ingresso ingresso = ingressoRepository.buscar(ingressoId);

            if (ingresso != null) {
                ingressoRepository.remover(ingresso);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
