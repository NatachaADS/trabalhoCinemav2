package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Ingresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.IngressoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Component
public class IngressoRepositoryImpl implements IngressoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Ingresso> listar() {
        return manager.createQuery("from Ingresso", Ingresso.class)
                .getResultList();
    }

    @Override
    public Ingresso buscar(Long id) {
        return manager.find(Ingresso.class, id);
    }

    @Transactional
    @Override
    public Ingresso salvar(Ingresso ingresso) {
        return manager.merge(ingresso);
    }

    @Transactional
    @Override
    public void remover(Ingresso ingresso) {
        ingresso = buscar(ingresso.getId());
        manager.remove(ingresso);
    }
}

