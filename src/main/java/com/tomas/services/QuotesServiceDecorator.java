package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.decorator.Delegate;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Alternative
public class QuotesServiceDecorator implements IQuoteService{

    @Inject @Delegate
    @Any
    IQuoteService quoteService;

    @Override
    public void addQuote(Samurai samurai) {
        if(samurai.getName()!="kebabas"){
            quoteService.addQuote(samurai);
            return;
        }
        throw new IllegalStateException("kebabas cannot have qoutes");

    }
}
