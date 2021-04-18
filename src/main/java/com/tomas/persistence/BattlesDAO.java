package com.tomas.persistence;

import com.tomas.entities.Battle;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class BattlesDAO {

    @Inject
    private EntityManager em;

    public List<Battle> loadAll() {
        return em.createNamedQuery("Battle.findAll", Battle.class).getResultList();
    }

    public void persist(Battle battle){
        this.em.persist(battle);
    }

    public Battle findOne(Long id){
        return em.find(Battle.class, id);
    }

    public Battle update(Battle battle){
        return em.merge(battle);
    }
}
