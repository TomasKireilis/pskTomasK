package com.tomas.usecases;

import com.tomas.entities.Battle;
import com.tomas.entities.Samurai;
import com.tomas.interceptors.LoggedInvocation;
import com.tomas.persistence.SamuraisDAO;
import com.tomas.services.IQuoteService;
import com.tomas.services.IdService;
import com.tomas.services.QuotesServiceB;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Model
@Getter @Setter
public class SamuraiDetails implements Serializable {

    @Inject
    private SamuraisDAO samuraisDAO;
    @Inject
    private IQuoteService quoteService;



    private Battle battle;


    private Samurai samurai;


    private Long samuraiIdToBeAdded;


    private Part quoteToBeUploaded;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String samuraiIdString = requestParameters.get("samuraiId");

        if (samuraiIdString != null) {

                Long samuraiId = Long.parseLong(samuraiIdString);

                samurai = samuraisDAO.findOne(samuraiId);
            System.out.println(samurai.getName());
                if(samurai == null || samurai.getId()==null){throw new IllegalArgumentException();}

        }
    }

    @Transactional
    @LoggedInvocation
    public String uploadQuote() {
        if (samurai != null) {
            quoteService.addQuote(samurai);

        }
        return "samuraiDetails?faces-redirect=true&samuraiId=" + samurai.getId();

    }

    @Transactional
    @LoggedInvocation
    public String addSamurai(Samurai samurai) {
        samuraisDAO.persist(samurai);
        return "samuraiDetails?faces-redirect=true&samuraiId=" + this.samurai.getId();
    }
}
