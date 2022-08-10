package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Filme;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.FilmeRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class FilmeRepositoryImpl implements FilmeRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Filme> listar() {
        return manager.createQuery("from Filme", Filme.class)
                .getResultList();
    }

    @Override
    public Filme buscar(Long id) {
        return manager.find(Filme.class, id);
    }

    @Transactional
    @Override
    public Filme salvar(Filme filme) {
        return manager.merge(filme);
    }

    @Transactional
    @Override
    public void remover(Filme filme) {
        filme = buscar(filme.getId());
        manager.remove(filme);
    }
}
