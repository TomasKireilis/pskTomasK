package com.tomas.usecases;

import com.tomas.entities.Battle;
import com.tomas.entities.Samurai;
import com.tomas.interceptors.LoggedInvocation;
import com.tomas.persistence.SamuraisDAO;
import com.tomas.services.ImageService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class SamuraiDetails implements Serializable {

    @Inject
    private SamuraisDAO samuraisDAO;
    @Inject
    private ImageService imageService;

    @Getter
    @Setter
    private Battle battle;

    @Getter
    @Setter
    private Samurai samurai;

    @Getter
    @Setter
    private Long samuraiIdToBeAdded;

    @Getter
    @Setter
    private Part quoteToBeUploaded;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String samuraiIdString = requestParameters.get("samuraiId");

        if (samuraiIdString != null) {
            try {
                Long samuraiId = Long.parseLong(samuraiIdString);
                this.samurai = samuraisDAO.findOne(samuraiId);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional
    @LoggedInvocation
    public String uploadQuote() {
        if (quoteToBeUploaded != null && samurai != null) {
            imageService.uploadQuote(quoteToBeUploaded, samurai);
        }

        return "samuraiDetails?faces-redirect=true&samuraiId=" + this.samurai.getId();
    }

    @Transactional
    @LoggedInvocation
    public String addSamurai(Samurai samurai) {
        samuraisDAO.persist(samurai);
        return "samuraiDetails?faces-redirect=true&samuraiId=" + this.samurai.getId();
    }
}
