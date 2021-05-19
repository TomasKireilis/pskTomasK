package com.tomas.usecases;
import com.tomas.services.QuotesServiceLongRandom;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named
public class SamuraiRandomLongQuote implements Serializable {

    @Inject
    private QuotesServiceLongRandom samuraiRandomLongQuote;
    private CompletableFuture<String> samuraiRandomLongQuoteTask = null;


    public String generateQuote() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();

        samuraiRandomLongQuoteTask = CompletableFuture.supplyAsync(() -> samuraiRandomLongQuote.generateQoute());

        return  "samuraiDetails?faces-redirect=true&samuraiId=" + requestParameters.get("samuraiId");
    }

    public boolean isGenerateQuoteRunning() {
        return samuraiRandomLongQuoteTask != null && !samuraiRandomLongQuoteTask.isDone();
    }

    public String getGenerateQuoteStatus() throws ExecutionException, InterruptedException {
        if (samuraiRandomLongQuoteTask == null) {
            return "";
        } else if (isGenerateQuoteRunning()) {
            return "Generation in progress";
        }
        return "Generated quote: " + samuraiRandomLongQuoteTask.get();
    }
}
