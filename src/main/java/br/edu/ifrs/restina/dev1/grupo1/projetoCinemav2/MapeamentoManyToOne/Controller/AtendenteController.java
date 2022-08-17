package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.AtendenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /atendentes HTTP/1.1


//4 component do spring
//@Controller

//8 restcontroler + responsebody
@RestController

//5 mapeando as requisicoes
@RequestMapping("/atendentes")

//7 indica que a resposta dos metodos desse controler, ir para o corpo
//@ResponseBody

public class AtendenteController {

    //2 definir variavel de instancia
    //3 injetar
    @Autowired
    private AtendenteRepository atendenteRepository;

    //6 mapear metodo para responder a requisicao
    @GetMapping

    //1 definir metodo
    public List<Atendente> listar(){
        return atendenteRepository.listar();
    }

//    @GetMapping("/{atendenteId}")
//    public Atendente buscar(@PathVariable Long atendenteId) {
//        return atendenteRepository.buscar(atendenteId);
//    }

    @GetMapping("/{atendenteId}")
    public ResponseEntity<Atendente> buscar(@PathVariable Long atendenteId) {
        Atendente atendente = atendenteRepository.buscar(atendenteId);

        if (atendente != null) {
            return ResponseEntity.ok(atendente);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Atendente adicionar (@RequestBody Atendente atendente) {
        return atendenteRepository.salvar(atendente);
    }

    @PutMapping("/{atendenteId}")
    public ResponseEntity<Atendente> atualizar (@PathVariable Long atendenteId, @RequestBody Atendente atendente) {

        Atendente atendenteAtual = atendenteRepository.buscar(atendenteId);

        if (atendenteAtual != null) {
            BeanUtils.copyProperties(atendente, atendenteAtual, "id");
            atendenteRepository.salvar(atendenteAtual);
            return ResponseEntity.ok(atendenteAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{atendenteId}")
    public ResponseEntity<Atendente> remover(@PathVariable Long atendenteId) {
        try {
            Atendente atendente = atendenteRepository.buscar(atendenteId);

            if (atendente != null) {
                atendenteRepository.remover(atendente);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
