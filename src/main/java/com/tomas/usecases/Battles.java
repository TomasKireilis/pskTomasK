package com.tomas.usecases;

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


    public void updateBattleName(String name){
        this.battleToCreate.setName(name);
    }

    private void loadAllBattles(){
        this.allBattles = battlesDAO.loadAll();
    }
}
