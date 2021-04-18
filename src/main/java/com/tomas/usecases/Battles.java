package com.tomas.usecases;

import com.tomas.entities.Samurai;
import com.tomas.services.IdService;
import lombok.Getter;
import lombok.Setter;
import com.tomas.entities.Battle;
import com.tomas.persistence.BattlesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Battles {

    @Inject
    private BattlesDAO battlesDAO;
    @Inject
    private IdService idService;

    @Getter
    @Setter
    private Battle battleToCreate;

    @Getter
    private List<Battle> allBattles;

    @PostConstruct
    public void init() {
        battleToCreate = new Battle();
        loadAllBattles();
    }

    @Transactional
    public String createBattle(){
        this.battlesDAO.persist(battleToCreate);
        return "index?faces-redirect=true";
    }

    private void loadAllBattles(){
        this.allBattles = battlesDAO.loadAll();
    }
}
