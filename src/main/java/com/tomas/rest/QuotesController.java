package com.tomas.rest;

import com.tomas.entities.Samurai;
import com.tomas.entities.SamuraiQuote;
import com.tomas.persistence.SamuraiQuotesDAO;
import com.tomas.persistence.SamuraisDAO;
import lombok.*;
import com.tomas.rest.contracts.SamuraiDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@ApplicationScoped
@Path("/quote")
public class QuotesController {

    @Inject
    private SamuraiQuotesDAO samuraiQuotesDAO;

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getById(@PathParam("id") final Long id) {
        SamuraiQuote quote = samuraiQuotesDAO.findOne(id);

        if (quote == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.ok(quote.getQuote()).build();
    }
}
