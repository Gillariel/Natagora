/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Application;
import com.helmo.al.natarest.util.ResponseBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
@Path("secure/application")
public class ApplicationsServices extends AbstractDao<Application> {

    public ApplicationsServices() {
        super(Application.class);
    }

    @GET
    @Path("{id/key}")
    @Produces({MediaType.TEXT_PLAIN})
    public Response find(@HeaderParam("key") String key) {
        boolean valid = super.validApplication(key);
        if(!valid)
            return Response.status(Response.Status.FORBIDDEN).build();
        else{
            return Response.ok("Valid").build();
        }
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return ResponseBuilder.buildGet(super.getAll());
    }
}
