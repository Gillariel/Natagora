/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Bird;
import com.helmo.al.natarest.util.ResponseBuilder;
import com.helmo.al.natarest.view.*;
import java.util.List;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
@Path("birds")
public class BirdsService extends AbstractDao<Bird> {
    public BirdsService() {
        super(Bird.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Bird entity) {
        return ResponseBuilder.buildPostEntity(super.save(entity));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Bird entity) {
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
    }

    @GET
    @Path("history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response history() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Month FROM history_new_birds");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("top")
    @Produces(MediaType.APPLICATION_JSON)
    public Response topBirds() {
        Query q = getEntityManager().createNativeQuery("SELECT Name, Number FROM top5_bird");
        return ResponseBuilder.buildGet((List<topBird>) q.getResultList());
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        return ResponseBuilder.buildGet(super.get(id));
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return ResponseBuilder.buildGet(super.getAll());
    }
}
