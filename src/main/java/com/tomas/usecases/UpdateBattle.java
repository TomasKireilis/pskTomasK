package com.tomas.usecases;

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
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        Long playerId = Long.parseLong(requestParameters.get("samuraiId"));
        this.samurai = samuraisDAO.findOne(playerId);
    }
}
