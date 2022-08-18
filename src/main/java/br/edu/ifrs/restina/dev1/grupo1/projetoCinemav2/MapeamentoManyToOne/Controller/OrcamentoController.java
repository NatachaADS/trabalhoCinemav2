package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Orcamento;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.OrcamentoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{orcamentoId}")
//    public Orcamento buscar(@PathVariable Long orcamentoId) {
//        return orcamentoRepository.buscar(orcamentoId);
//    }

    @GetMapping("/{orcamentoId}")
    public ResponseEntity<Orcamento> buscar(@PathVariable Long orcamentoId) {
        Orcamento orcamento = orcamentoRepository.buscar(orcamentoId);

        if (orcamento != null) {
            return ResponseEntity.ok(orcamento);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Orcamento adicionar (@RequestBody Orcamento orcamento) {
        return orcamentoRepository.salvar(orcamento);
    }

    @PutMapping("/{orcamentoId}")
    public ResponseEntity<Orcamento> atualizar (@PathVariable Long orcamentoId, @RequestBody Orcamento orcamento) {

        Orcamento orcamentoAtual = orcamentoRepository.buscar(orcamentoId);

        if (orcamentoAtual != null) {
            BeanUtils.copyProperties(orcamento, orcamentoAtual, "id");
            orcamentoRepository.salvar(orcamentoAtual);
            return ResponseEntity.ok(orcamentoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{orcamentoId}")
    public ResponseEntity<Orcamento> remover(@PathVariable Long orcamentoId) {
        try {
            Orcamento orcamento = orcamentoRepository.buscar(orcamentoId);

            if (orcamento != null) {
                orcamentoRepository.remover(orcamento);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
