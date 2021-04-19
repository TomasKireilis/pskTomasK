package com.tomas.usecases;

import com.tomas.mybatis.dao.SamuraiMapper;

import com.tomas.mybatis.model.Samurai;
import com.tomas.services.IdService;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Console;
import java.util.List;


@Model
@Getter @Setter
public class Samurais {

    @Inject
    private SamuraiMapper samuraisMapper;
    @Inject
    private IdService idService;


    private Samurai samuraiToCreate;


    private List<Samurai> allSamurais;

    @PostConstruct
    public void init(){
        samuraiToCreate = new Samurai();
        loadAllSamurais();
    }

    @Transactional
    public String createSamurai(){
        if(samuraiToCreate!=null) {
//            samuraiToCreate.setId(idService.getId());
            System.out.println(samuraiToCreate.getId());
            System.out.println(samuraiToCreate.getName());
            samuraisMapper.insert(samuraiToCreate);
            return "samurais?faces-redirect=true";
        }
        return "samurais?faces-redirect=true";
    }

    private void loadAllSamurais(){
        this.allSamurais = samuraisMapper.selectAll();
    }
}
