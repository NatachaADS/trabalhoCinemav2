package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.Controller;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.AtendenteRepository;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.IngressoRepository;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.VendaIngressoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class AtendenteIngressoController {

    @Autowired
    private AtendenteRepository  atendenteRepository;

    @Autowired
    private VendaIngressoRepository vendaIngressoRepository;

//    @Autowired
//    private IngressoRepository ingressoRepository;

    @GetMapping("/atendentes/{atendenteId}/vendaIngressos")
    public ResponseEntity<VendaIngresso> listar(@PathVariable Long atendenteId) {
       //VendaIngresso vendaIngresso = vendaIngressoRepository.buscar(atendenteId);
        Atendente atendente = atendenteRepository.buscar(atendenteId);

        if (atendente != null) {
            return ResponseEntity.ok(atendente.getVendaIngresso());
        }

        return ResponseEntity.notFound().build();
    }

    @Transactional
    @PostMapping("/atendentes/{atendenteId}/vendaIngressos")
    @ResponseStatus(HttpStatus.CREATED)
    public VendaIngresso adicionar (@PathVariable Long atendenteId,
                                    @RequestBody VendaIngresso vendaIngresso) {
        vendaIngresso.setId(0L);
        VendaIngresso  vendaIngressoSalvo = vendaIngressoRepository.salvar(vendaIngresso);
        Atendente atendente = atendenteRepository.buscar(atendenteId);
        //atendente.getVendaIngresso().setHorarioVendaIngresso(vendaIngresso.getHorarioVendaIngresso());
        vendaIngressoRepository.salvar(atendente.getVendaIngresso());
        return vendaIngressoSalvo;
    }

}
