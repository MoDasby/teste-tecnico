package com.modasby.testetecnico.repository;

import com.modasby.testetecnico.Entities.Pessoa;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
@ApplicationScoped
public class PessoaRepository implements Repository<Pessoa>, Serializable {

    private EntityManager entityManager;

    public PessoaRepository() {}

    @Inject
    public PessoaRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Pessoa pessoa) {
        entityManager.getTransaction().begin();
        entityManager.persist(pessoa.getEndereco());
        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
    }

    @Override
    public Pessoa findById(Long id) {
        return entityManager.createQuery("select p from Pessoa p where p.id = :id", Pessoa.class).setParameter("id", id).getSingleResult();
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("SELECT p FROM Pessoa p", Pessoa.class)
                .getResultList();
    }

    @Override
    @Transactional
    public void delete(Pessoa pessoa) {
        pessoa = entityManager.merge(pessoa);

        entityManager.remove(pessoa);
    }

    @Override
    @Transactional
    public Pessoa update(Pessoa pessoa) {
        entityManager.merge(pessoa);

        return pessoa;
    }
}
