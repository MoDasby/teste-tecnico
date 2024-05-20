package com.modasby.testetecnico.config;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ManagedBean
public class HibernateConfig {

    @Produces
    @ApplicationScoped
    public EntityManager getEntityManager() {
        return Persistence.createEntityManagerFactory("teste-tecnico-PU").createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
