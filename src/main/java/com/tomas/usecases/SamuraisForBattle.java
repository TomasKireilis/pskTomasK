package com.tomas.usecases;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

import com.tomas.entities.Samurai;
import com.tomas.persistence.SamuraisDAO;
import lombok.Getter;
import lombok.Setter;
import com.tomas.entities.Battle;
import com.tomas.persistence.BattlesDAO;

@Model
public class SamuraisForBattle implements Serializable {

    @Inject
    private SamuraisDAO samuraisDAO;
    @Inject
    private BattlesDAO battlesDAO;

    @Getter
    @Setter
    private Battle battle;

    @Getter
    @Setter
    private Samurai samuraiToAdd = new Samurai();

    @Getter
    @Setter
    private String samuraiIdToBeAdded;

    @Getter
    @Setter
    private List<Samurai> availableSamurais;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        String battleIdString = requestParameters.get("battleId");

        if (battleIdString != null) {
            Long battleId = Long.parseLong(battleIdString);
            this.battle = battlesDAO.findOne(battleId);
        }
        addExistingSamurais();
    }

    @Transactional
    public String addSamurai() {

        try {
            Long id = Long.parseLong(samuraiIdToBeAdded);

            Samurai samurai = samuraisDAO.findOne(id);

            if (samurai != null && !battle.getSamurais().contains(samurai)) {
                battle.getSamurais().add(samurai);
                battlesDAO.update(battle);
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "battleDetails?battleId=" + this.battle.getId();
        }

       return "battleDetails?battleId=" + this.battle.getId();
    }

    @Transactional
    public void addExistingSamurais() {
            List<Samurai> existingSamurais = battle.getSamurais();
            List<Samurai> allSamurai = samuraisDAO.loadAll();

      availableSamurais = allSamurai.stream()
                .filter(c -> !existingSamurais.contains(c)) .collect(Collectors.toList());
//            for (Samurai sam: allSamurai) {
//                if(!existingSamurais.contains(sam)){
//                    availableSamurais.add(sam);
//                }
//            }
    }


}