package com.tomas.usecases;


import com.tomas.interceptors.LoggedInvocation;
import lombok.Getter;
import lombok.Setter;
import com.tomas.entities.Samurai;
import com.tomas.persistence.SamuraisDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class UpdateBattle implements Serializable {

    private Samurai samurai;

    @Inject
    private SamuraisDAO samuraisDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateSamurai init() called");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Long playerId = Long.parseLong(requestParameters.get("samuraiId"));
        this.samurai = samuraisDAO.findOne(playerId);
    }

    /*
    @Transactional
    @LoggedInvocation
    public String updatePlayerJerseyNumber() {
        try{
            samuraisDAO.update(this.samurai);
        } catch (OptimisticLockException e) {
            return "/samuraiDetails.xhtml?faces-redirect=true&playerId=" + this.samurai.getId() + "&error=optimistic-lock-exception";
        }
        return "battleDetails.xhtml?teamId=" + this.player.getTeam().getId() + "&faces-redirect=true";
    }

     */
}
