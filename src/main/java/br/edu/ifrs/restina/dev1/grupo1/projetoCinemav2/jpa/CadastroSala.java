package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.entidade.Sala;


@Component
public class CadastroSala {

    @PersistenceContext
    private EntityManager manager;

    public List<Sala> listar() {
        return manager.createQuery("from Sala", Sala.class)
                .getResultList();
    }

    @Transactional
    public Sala adicionar(Sala sala) {
        //insert into
        //retorna instancia persistida
        return manager.merge(sala);
    }

    public Sala buscar(Long id) {
        return manager.find(Sala.class, id);
    }
}
