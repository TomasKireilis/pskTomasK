package com.tomas.rest;
import com.tomas.entities.Battle;
import com.tomas.persistence.BattlesDAO;
import com.tomas.rest.contracts.BattleDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@ApplicationScoped
@Path("/battle")
public class BattleController {
    @Inject
    @Setter
    @Getter
    private BattlesDAO battlesDAO;


    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final long id) {
        Battle battle = battlesDAO.findOne(id);
        if (battle == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        BattleDto battleDto = new BattleDto();
        battleDto.setId(battle.getId());
        battleDto.setName(battle.getName());
        battleDto.setCreationDate(battle.getCreationDate());

        return Response.ok(battleDto).build();
    }

    @Path("/{id}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)  @Transactional

    public Response update(@PathParam("id") final long id, BattleDto data) {
        try {
            Battle existingBattle = battlesDAO.findOne(id);
            if (existingBattle == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingBattle.setName(data.getName());
            existingBattle.setCreationDate(data.getCreationDate());
            battlesDAO.update(existingBattle);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }

    @Path("")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(BattleDto data) {
        try {
            Battle newBattle = new Battle();
            newBattle.setName(data.getName());
            newBattle.setCreationDate(data.getCreationDate());
            battlesDAO.persist(newBattle);
            Battle battle = battlesDAO.findOne(newBattle.getId());
            if (battle == null) {
                return Response.status(Response.Status.EXPECTATION_FAILED).build();
            }
            return Response.ok(battle.getId()).build();
        } catch (Exception ole) {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
}
