package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class QuotesServiceC implements IQuoteService{

    @Inject
    private SamuraisDAO samuraisDAO;

    @Inject
    private IdService idService;
    private String[] quoteArray = new String[]{"My quote","my another quote", "comn guys",};


    public void addQuote(Samurai samurai) {
        List<SamuraiQuote> currentQuotes = samurai.getQuotes();

        int random = ThreadLocalRandom.current().nextInt(0, 3);
        long id = samurai.getId();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentQuotes.add(SamuraiQuote.builder()
                .samuraiId(id)
                .text(quoteArray[random]+idService.getId().toString())
                .build());

        samurai.setQuotes(currentQuotes);
        samuraisDAO.update(samurai);
    }
}
