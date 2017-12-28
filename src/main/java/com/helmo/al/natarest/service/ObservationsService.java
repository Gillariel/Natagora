/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Observation;
import com.helmo.al.natarest.util.ResponseBuilder;
import com.helmo.al.natarest.util.VisionChecker;
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
@Path("observations")
public class ObservationsService extends AbstractDao<Observation> {

    public ObservationsService() {
        super(Observation.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Observation entity) {
        String url = "https://storage.googleapis.com/natamobile/" + entity.getMedia().getUrl();
        switch(VisionChecker.check(url)){
            case 0: {
                entity.getMedia().setDeleted((short)1);
                entity.getMedia().setValidated((short)0);
            } 
            case 2: {
                entity.getMedia().setValidated((short)0);  
            }
            default: {
                entity.getMedia().setUrl(url);
                //Need to manually referenced each other to do INSERT INTO
                entity.setMedia(entity.getMedia());
                entity.getMedia().setObservation(entity);
                return ResponseBuilder.buildPost(super.save(entity));
            }
        }    
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Observation entity) {
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
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
