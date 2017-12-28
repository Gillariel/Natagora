/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Media;
import static com.helmo.al.natarest.service.AbstractDao.getEntityManager;
import com.helmo.al.natarest.util.ResponseBuilder;
import com.helmo.al.natarest.view.BirdByMonth;
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
@Path("media")
public class MediaService extends AbstractDao<Media> {


    public MediaService() {
        super(Media.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Media entity) {
        entity.setUrl("https://storage.googleapis.com/natamobile/" + entity.getUrl());
        return ResponseBuilder.buildPost(super.save(entity));
    }

    @PUT
    @Path("delete/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response setNotValid(@PathParam("id") Integer id) {
        Media m = super.get(id);
        m.setDeleted((short) 1);
        return ResponseBuilder.buildPut(super.update(m));
    }
    
    @PUT
    @Path("validate/{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response setValid(@PathParam("id") Integer id) {
        Media m = super.get(id);
        m.setValidated((short) 1);
        return ResponseBuilder.buildPut(super.update(m));
    }
    
    @PUT
    @Path("{id}")
    @Consumes({ MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Media entity) {
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
    }
    
    @GET
    @Path("count/type")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response CountByType() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Type FROM count_media_by_type");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("history/pending")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response historyPending() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Month FROM history_new_media WHERE Has_Been_Pended = 1");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("history/created")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response history() {
        Query q = getEntityManager().createNativeQuery("SELECT Number, Month FROM history_new_media");
        return ResponseBuilder.buildGet((List<BirdByMonth>) q.getResultList());
    }
    
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        return ResponseBuilder.buildGet(super.get(id));
    }

    @GET
    @Path("validated")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getValidated() {
        return ResponseBuilder.buildGet(
            getEntityManager().createQuery("SELECT m FROM Media m WHERE m.validated = 1")
                .getResultList()
        );
    }
    
    @GET
    @Path("pending")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response getPending() {
        return ResponseBuilder.buildGet(
            getEntityManager().createQuery("SELECT m FROM Media m WHERE m.validated = 0")
                .getResultList()
        );
    }
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response findAll() {
        return ResponseBuilder.buildGet(super.getAll());
    }
}
