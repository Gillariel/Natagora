/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Color;
import com.helmo.al.natarest.util.ResponseBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
@Path("colors")
public class ColorService extends AbstractDao<Color> {
    public ColorService() {
        super(Color.class);
    }
    
    @GET
    @Path("byName/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("name") String name) {
        return ResponseBuilder.buildGet(
            getEntityManager().createQuery("SELECT c FROM Color c WHERE c.name = :name", Color.class)
                .setParameter("name", name)
                .getSingleResult()
        );
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
