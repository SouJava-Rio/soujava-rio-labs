package br.org.soujava.rio.helidon.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
public class EventProduces {

    @Produces
    @ApplicationScoped
    public EntityManager createEntityManager() {
        EntityManagerFactory em = Persistence.createEntityManagerFactory("event-demo");
        return em.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager manager) {
        if (manager.isOpen()) {
            manager.close();
        }
    }
}