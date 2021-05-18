package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Decorator
public class QuotesServiceDecorator implements IQuoteService{

    @Inject @Delegate
    @Any
    IQuoteService quoteService;

    @Override
    public void addQuote(Samurai samurai) {
        String name = samurai.getName();
        if(!(name.equals("kebabas"))){
            quoteService.addQuote(samurai);
            return;
        }
        throw new IllegalArgumentException("intensional program design error. kebabas cannot have qoutes");

    }
}
