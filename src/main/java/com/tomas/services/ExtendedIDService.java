package com.tomas.services;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraisDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@ApplicationScoped
@Specializes
public class ExtendedIDService extends IdService {

    private Long id = 1000L;

    public Long getId() {
        return id++;
    }
}