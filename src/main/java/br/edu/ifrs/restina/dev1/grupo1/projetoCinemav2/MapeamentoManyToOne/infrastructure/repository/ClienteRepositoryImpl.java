package br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.infrastructure.repository;

import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.model.Cliente;
import br.edu.ifrs.restina.dev1.grupo1.projetoCinemav2.MapeamentoManyToOne.domain.repository.ClienteRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ClienteRepositoryImpl implements ClienteRepository {
    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Cliente> listar() {
        return manager.createQuery("from Cliente", Cliente.class)
                .getResultList();
    }

    @Override
    public Cliente buscar(Long id) {

        return manager.find(Cliente.class, id);
    }

    @Transactional
    @Override
    public Cliente salvar(Cliente cliente) {

        return manager.merge(cliente);
    }

    @Transactional
    @Override
    public void remover(Cliente cliente) {
        cliente = buscar(cliente.getId());
        manager.remove(cliente);
    }
}
