/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Bird;
import com.helmo.al.natarest.util.GSONParser;
import java.util.List;
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
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Bird entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Bird entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        Bird birds = super.find(id);
        if(birds == null)
            return Response.status(Response.Status.NOT_FOUND).entity(birds).build();
        return Response.ok(birds).build();
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAlll() {
        List<Bird> birds = super.findAll();
        if(birds == null)
            return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(GSONParser.Parse(birds)).build();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Bird> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected void finalize() throws Throwable {
        this.getEntityManager().close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
}
