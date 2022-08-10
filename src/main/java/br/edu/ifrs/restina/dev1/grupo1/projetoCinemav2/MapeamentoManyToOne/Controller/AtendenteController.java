package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;


import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
