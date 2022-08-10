package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Sessao;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.SessaoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class SessaoRepositoryImpl implements SessaoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Sessao> listar() {
        return manager.createQuery("from Sessao", Sessao.class)
                .getResultList();
    }

    @Override
    public Sessao buscar(Long id) {
        return manager.find(Sessao.class, id);
    }

    @Transactional
    @Override
    public Sessao salvar(Sessao sessao) {
        return manager.merge(sessao);
    }

    @Transactional
    @Override
    public void remover(Sessao sessao) {
        sessao = buscar(sessao.getId());
        manager.remove(sessao);
    }
}
