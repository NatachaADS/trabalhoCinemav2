package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.VendaIngresso;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.VendaIngressoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class VendaIngressoRepositoryImpl implements VendaIngressoRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<VendaIngresso> listar() {
        return manager.createQuery("from VendaIngresso", VendaIngresso.class)
                .getResultList();
    }

    @Override
    public VendaIngresso buscar(Long id) {
        return manager.find(VendaIngresso.class, id);
    }

    @Transactional
    @Override
    public VendaIngresso salvar(VendaIngresso vendaIngresso) {
        return manager.merge(vendaIngresso);
    }

    @Transactional
    @Override
    public void remover(VendaIngresso vendaIngresso) {
        vendaIngresso = buscar(vendaIngresso.getId());
        manager.remove(vendaIngresso);
    }
}
