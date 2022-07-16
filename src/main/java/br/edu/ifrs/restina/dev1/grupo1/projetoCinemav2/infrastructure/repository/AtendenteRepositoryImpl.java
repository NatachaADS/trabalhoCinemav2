package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Atendente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.AtendenteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class AtendenteRepositoryImpl implements AtendenteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Atendente> listar() {
        return manager.createQuery("from Atendente", Atendente.class)
                .getResultList();
    }

    @Override
    public Atendente buscar(Long id) {

        return manager.find(Atendente.class, id);
    }

    @Transactional
    @Override
    public Atendente salvar(Atendente atendente) {

        return manager.merge(atendente);
    }

    @Transactional
    @Override
    public void remover(Atendente atendente) {
        atendente = buscar(atendente.getId());
        manager.remove(atendente);
    }
}
