package com.tomas.services;

import com.tomas.interceptors.MethodLogger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;

@ApplicationScoped
@Specializes
@MethodLogger
public class ExtendedIDService extends IdService {

    private Long id = 1000L;

    public Long getId() {
        return id++;
    }
}