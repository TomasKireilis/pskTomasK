package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
public class QuotesServiceLongRandom{

    public String generateQoute(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
                throw new IllegalArgumentException();
        }
        String uuid = UUID.randomUUID().toString();
       uuid =  uuid.replace("-", "");
        return uuid;
    }
}
