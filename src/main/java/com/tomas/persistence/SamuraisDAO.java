package com.tomas.persistence;

import com.tomas.entities.Samurai;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SamuraisDAO {

    @Inject
    private EntityManager em;

    public List<Samurai> loadAll() {
        return em.createNamedQuery("Samurai.findAll", Samurai.class).getResultList();
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public void persist(Samurai samurai){
        this.em.persist(samurai);
    }

    public Samurai findOne(Long id) {
        return em.find(Samurai.class, id);
    }

    public Samurai update(Samurai samurai){
        return em.merge(samurai);
    }
}
