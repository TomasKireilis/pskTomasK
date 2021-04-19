package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class QuotesService {

    @Inject
    private SamuraisDAO samuraisDAO;

    private String[] quoteArray = new String[]{"My quote","my another quote", "comn guys",
            "Are you serious?",
            "eeee comon...",
            "how much more...",
            "hi",
            "when will covid dissapear?", "i like piza","strawberry blue or orangy white?","please...", "is there anybody?", "Youy got the MOST positive quote :D)",
             "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)", "Youy got the MOST positive quote :D)"};

    public void addQuote(Samurai samurai) {
        List<SamuraiQuote> currentQuotes = samurai.getQuotes();

        int random = ThreadLocalRandom.current().nextInt(0, 21);
        long id = samurai.getId();
        currentQuotes.add(SamuraiQuote.builder()
                .samuraiId(id)
                .text(quoteArray[random])
                .build());

        samurai.setQuotes(currentQuotes);
        samuraisDAO.update(samurai);
    }
}
