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

@ApplicationScoped
public class ImageService {

    @Inject
    private SamuraisDAO samuraisDAO;

    public BufferedImage resize(BufferedImage image) {
        return null;
    }

    public void uploadQuote(Part image, Samurai samurai) {
        try {
            byte[] blob = image.getInputStream().readAllBytes();
            List<SamuraiQuote> currentQuotes = samurai.getQuotes();

            currentQuotes.add(SamuraiQuote.builder()
                    .samuraiId(samurai.getId())
                    .quote(blob)
                    .build());

            samurai.setQuotes(currentQuotes);
            samuraisDAO.update(samurai);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
