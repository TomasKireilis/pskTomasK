

package com.tomas.services;

import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;

@ApplicationScoped
public class IdService implements Serializable {

    private Long id = 1L;

    public Long getId() {
        return id++;
    }
}