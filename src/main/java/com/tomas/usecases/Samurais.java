package com.tomas.usecases;

import com.tomas.entities.Battle;
import com.tomas.entities.Samurai;
import com.tomas.persistence.SamuraisDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Samurais {

    @Inject
    private SamuraisDAO samuraisDAO;

    @Getter
    @Setter
    private Samurai samuraiToCreate;

    @Getter
    private List<Samurai> allSamurais;

    @PostConstruct
    public void init(){
        samuraiToCreate = new Samurai();
        loadAllSamurais();
    }

    @Transactional
    public String createSamurai(){
        this.samuraisDAO.persist(samuraiToCreate);
        return "samurais?faces-redirect=true";
    }

    private void loadAllSamurais(){
        this.allSamurais = samuraisDAO.loadAll();
    }
}
