/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.User;
import static com.helmo.al.natarest.service.AbstractDao.getEntityManager;
import com.helmo.al.natarest.util.ResponseBuilder;
import com.helmo.al.natarest.view.BirdByMonth;
import java.util.List;
import javax.persistence.Query;
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
    @Path("/secure")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSecure(@HeaderParam("passwd") String passwd, User entity) {
        if(entity.getPicture().isEmpty())
            entity.setPicture("https://greenni.org/user/dist/img/user2-160x160.jpg");
        entity.setPassword(passwd);
        return ResponseBuilder.buildPostEntity(super.saveAndReturn(entity));
    }

    @PUT
    @Path("secure/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@HeaderParam("passwd") String passwd, @PathParam("id") Integer id, User entity) {
        entity.setPassword(passwd);
        return ResponseBuilder.buildPut(super.update(entity));
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
    @Path("vsFb")
    @Produces(MediaType.APPLICATION_JSON)
    public Response vsFb() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Fb FROM vs_fb");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("byRole")
    @Produces(MediaType.APPLICATION_JSON)
    public Response byRole() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Name FROM user_by_role");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("history")
    @Produces(MediaType.APPLICATION_JSON)
    public Response history() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Month FROM user_history_by_month");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("check/{mail}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response check(@PathParam("mail") String mail){
        return ResponseBuilder.buildBlank(getEntityManager().createQuery(
            "SELECT u FROM User u WHERE u.mail = :mail"
        ).setParameter("mail", mail)
        .getResultList().size() == 1);
    }
    
    @GET
    @Path("loginAdmin/{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginAdmin(@HeaderParam("passwd") String password, @PathParam("username") String username){
        return ResponseBuilder.buildGet(getEntityManager().createQuery(
            "SELECT u FROM User u WHERE u.pseudo = :username AND u.password = :password AND u.role.id = 2"
        ).setParameter("username", username)
        .setParameter("password", password)
        .getSingleResult());
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
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return ResponseBuilder.buildGet(super.getAll());
    }
}
