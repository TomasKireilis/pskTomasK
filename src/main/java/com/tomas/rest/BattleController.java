package com.tomas.rest;

import com.tomas.entities.Battle;
import com.tomas.persistence.BattlesDAO;
import com.tomas.rest.contracts.BattleDto;
import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
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
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(
            @PathParam("id") final Integer playerId,
            PlayerDto playerData) {
        try {
            Player existingPlayer = battlesDAO.findOne(playerId);
            if (existingPlayer == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            existingPlayer.setName(playerData.getName());
            existingPlayer.setJerseyNumber(playerData.getJerseyNumber());
            battlesDAO.update(existingPlayer);
            return Response.ok().build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
