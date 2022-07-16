package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.model.Sala;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.domain.repository.SalaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class SalaRepositoryImpl implements SalaRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Sala> listar() {
        return manager.createQuery("from Sala", Sala.class)
                .getResultList();
    }

    @Override
    public Sala buscar(Long id) {
        return manager.find(Sala.class, id);
    }

    @Transactional
    @Override
    public Sala salvar(Sala sala) {
        return manager.merge(sala);
    }

    @Transactional
    @Override
    public void remover(Sala sala) {
        sala = buscar(sala.getId());
        manager.remove(sala);
    }
}
