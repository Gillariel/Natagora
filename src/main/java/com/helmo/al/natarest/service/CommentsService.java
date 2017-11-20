/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Comment;
import com.helmo.al.natarest.util.ResponseBuilder;
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
@Path("comments")
public class CommentsService extends AbstractDao<Comment> {
    public CommentsService() {
        super(Comment.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Comment entity) {
        return ResponseBuilder.buildPost(super.save(entity));
    }
    
    @PUT
    @Path("validate/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response setValid(@PathParam("id") Integer id) {
        Comment c = super.get(id);
        c.setReported(false);
        return ResponseBuilder.buildPut(super.update(c));
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Comment entity) {
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
    }

    @GET
    @Path("reported")
    @Produces(MediaType.APPLICATION_JSON)
    public Response allReported(){
        return ResponseBuilder.buildGet((getEntityManager().createQuery("SELECT c FROM Comment c WHERE c.reported = true").getResultList()));
    }
    
    @GET
    @Path("reported/count")
    @Produces(MediaType.APPLICATION_JSON)
    public Response countReported(){
        long result;
        try{
            Query q = getEntityManager().createNativeQuery("SELECT Number FROM Count_Reported_Comments");
            result = (long) q.getSingleResult();
        } catch(Exception e){
            result =  0;
        }
        return ResponseBuilder.buildGet(result);
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

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return  ResponseBuilder.buildGet(super.getRange(new int[]{from, to}));
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return ResponseBuilder.buildGet(String.valueOf(super.count()));
    }  
}
