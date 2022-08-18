package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.VendaIngressoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /vendaIngressos HTTP/1.1

//4 component do spring
//@Controller


//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/vendaIngressos")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class VendaIngressoController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private VendaIngressoRepository vendaIngressoRepository;


    //6 mapear metodo para responder a requisicao
    @GetMapping
    //1 definir metodo
    public List<VendaIngresso> listar(){
        return vendaIngressoRepository.listar();
    }

//    @GetMapping("/{vendaIngressoId}")
//    public VendaIngresso buscar(@PathVariable Long vendaIngressoId) {
//        return vendaIngressoRepository.buscar(vendaIngressoId);
//    }

    @GetMapping("/{vendaIngressoId}")
    public ResponseEntity<VendaIngresso> buscar(@PathVariable Long vendaIngressoId) {
        VendaIngresso vendaIngresso = vendaIngressoRepository.buscar(vendaIngressoId);

        if (vendaIngresso != null) {
            return ResponseEntity.ok(vendaIngresso);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaIngresso adicionar (@RequestBody VendaIngresso vendaIngresso) {
        return vendaIngressoRepository.salvar(vendaIngresso);
    }

    @PutMapping("/{vendaIngressoId}")
    public ResponseEntity<VendaIngresso> atualizar (@PathVariable Long vendaIngressoId, @RequestBody VendaIngresso vendaIngresso) {

        VendaIngresso vendaIngressoAtual = vendaIngressoRepository.buscar(vendaIngressoId);

        if (vendaIngressoAtual != null) {
            BeanUtils.copyProperties(vendaIngresso, vendaIngressoAtual, "id");
            vendaIngressoRepository.salvar(vendaIngressoAtual);
            return ResponseEntity.ok(vendaIngressoAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{vendaIngressoId}")
    public ResponseEntity<VendaIngresso> remover(@PathVariable Long vendaIngressoId) {
        try {
            VendaIngresso vendaIngresso = vendaIngressoRepository.buscar(vendaIngressoId);

            if (vendaIngresso != null) {
                vendaIngressoRepository.remover(vendaIngresso);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
