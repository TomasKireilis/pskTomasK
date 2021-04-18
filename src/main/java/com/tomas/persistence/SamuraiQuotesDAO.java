package com.tomas.persistence;

import com.tomas.entities.SamuraiQuote;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SamuraiQuotesDAO {

    @Inject
    private EntityManager em;

    public List<SamuraiQuote> loadAll() {
        return em.createNamedQuery("SamuraiQuote.findAll", SamuraiQuote.class).getResultList();
    }

    public void persist(SamuraiQuote samuraiQuote){
        this.em.persist(samuraiQuote);
    }

    public SamuraiQuote findOne(Long id){
        return em.find(SamuraiQuote.class, id);
    }

    public SamuraiQuote update(SamuraiQuote samuraiQuote){
        return em.merge(samuraiQuote);
    }
}
