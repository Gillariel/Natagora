/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.User;
import com.helmo.al.natarest.util.ResponseBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
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

@Path("users")
public class UsersService extends AbstractDao<User> {

    public UsersService() {
        super(User.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(User entity) {
        return ResponseBuilder.buildPost(super.save(entity));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, User entity) {
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
    }

    @GET
    @Path("login/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@HeaderParam("passwd") String password, @PathParam("username") String username){
        return ResponseBuilder.buildGet(getEntityManager().createQuery(
            "SELECT u FROM User u WHERE u.pseudo = :username AND u.password = :password"
        ).setParameter("username", username)
        .setParameter("password", password)
        .getSingleResult());
    }
    
    @GET
    @Path("trylogin/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response trylogin(@HeaderParam("passwd") String password, @PathParam("username") String username){
        return ResponseBuilder.buildBlank(getEntityManager().createQuery(
            "SELECT u FROM User u WHERE u.pseudo = :username AND u.password = :password"
        ).setParameter("username", username)
        .setParameter("password", password)
        .getResultList().size() == 1);
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
        return ResponseBuilder.buildGet(super.getRange(new int[]{from, to}));
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public Response countREST() {
        return ResponseBuilder.buildGet(String.valueOf(super.count()));
    }

}
