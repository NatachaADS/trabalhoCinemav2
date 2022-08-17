package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.VendaIngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping("/{vendaIngressoId}")
    public VendaIngresso buscar(@PathVariable Long vendaIngressoId) {
        return vendaIngressoRepository.buscar(vendaIngressoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaIngresso adicionar (@RequestBody VendaIngresso vendaIngresso) {
        return vendaIngressoRepository.salvar(vendaIngresso);
    }
}
