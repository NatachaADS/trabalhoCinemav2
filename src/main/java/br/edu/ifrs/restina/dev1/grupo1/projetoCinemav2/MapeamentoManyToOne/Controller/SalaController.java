package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sala;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SalaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @GetMapping("/{salaId}")
//    public Sala buscar(@PathVariable Long salaId) {
//        return salaRepository.buscar(salaId);
//    }

    @GetMapping("/{salaId}")
    public ResponseEntity<Sala> buscar(@PathVariable Long salaId) {
        Sala sala = salaRepository.buscar(salaId);

        if (sala != null) {
            return ResponseEntity.ok(sala);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Sala adicionar (@RequestBody Sala sala) {
        return salaRepository.salvar(sala);
    }

    @PutMapping("/{salaId}")
    public ResponseEntity<Sala> atualizar (@PathVariable Long salaId, @RequestBody Sala sala) {

        Sala salaAtual = salaRepository.buscar(salaId);

        if (salaAtual != null) {
            BeanUtils.copyProperties(sala, salaAtual, "id");
            salaRepository.salvar(salaAtual);
            return ResponseEntity.ok(salaAtual);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{salaId}")
    public ResponseEntity<Sala> remover(@PathVariable Long salaId) {
        try {
            Sala sala = salaRepository.buscar(salaId);

            if (sala != null) {
                salaRepository.remover(sala);
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.notFound().build();
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
