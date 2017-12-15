/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.entity.Session;
import com.helmo.al.natarest.util.ResponseBuilder;
import com.helmo.al.natarest.view.MediaView;
import com.helmo.al.natarest.view.ObsMedia;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author foers
 */
@Path("sessions")
public class SessionsService extends AbstractDao<Session> {

    public SessionsService() {
        super(Session.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Session entity) {
        try{
            if(entity.getLatitude() != 0 && entity.getLongitude() != 0) {
                Client client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
                WebTarget target = client.target("http://api.openweathermap.org/data/2.5/weather?lat=50.5594&lon=5.95566&APPID=c1145c96152562696e7eab6009954d02");
                String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
                JSONObject res = new JSONObject(json);
                JSONArray weather = res.getJSONArray("weather");
                String weatherType = weather.getJSONObject(0).getString("main");
                entity.setWeather(weatherType);
            }
        }catch(JSONException e) {
            
        }
        return ResponseBuilder.buildPostEntity(super.saveAndReturn(entity));
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response edit(@PathParam("id") Integer id, Session entity) {
        try{
            if(entity.getLatitude() != 0 && entity.getLongitude() != 0) {
                Client client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
                WebTarget target = client.target("http://api.openweathermap.org/data/2.5/weather?lat=50.5594&lon=5.95566&APPID=c1145c96152562696e7eab6009954d02");
                String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
                JSONObject res = new JSONObject(json);
                JSONArray weather = res.getJSONArray("weather");
                String weatherType = weather.getJSONObject(0).getString("main");
                entity.setWeather(weatherType);
            }
        }catch(JSONException e) {
            
        }
        return ResponseBuilder.buildPut(super.update(entity));
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Integer id) {
        return ResponseBuilder.buildDelete(super.delete(super.get(id)));
    }

    @GET
    @Path("observationsMedia/pended/{username}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response observationsMediaPendedByUsername(@PathParam("username") String username) {
        List<ObsMedia> result = getEntityManager().createNativeQuery("SELECT * FROM observations_media_by_session_id WHERE Pseudo = '#username' AND Validated = 0")
                .setParameter("username", username)
                .getResultList();
        return ResponseBuilder.buildGet(result);
    }
    
    @GET
    @Path("observationsMedia")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response observationsMediaValidatedByUsername() {
        List<ObsMedia> result = getEntityManager().createNativeQuery("SELECT * FROM observations_media_by_session_id WHERE Validated = 1")
                .getResultList();
        return ResponseBuilder.buildGet(result);
    }
    
    @GET
    @Path("observationsMedia/validated/{username}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response observationsMediaValidatedByUsername(@PathParam("username") String username) {
        List<ObsMedia> result = getEntityManager().createNativeQuery("SELECT * FROM observations_media_by_session_id WHERE Pseudo = #username AND Validated = 1")
                .setParameter("username", username)
                .getResultList();
        return ResponseBuilder.buildGet(result);
    }
    
    @GET
    @Path("observationsMedia/{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response observationsMediaById(@PathParam("id") Integer id) {
        List<MediaView> result = getEntityManager().createNativeQuery("SELECT * FROM observations_media_by_session_id WHERE Sessions_ID = #ID")
                .setParameter("ID", id)
                .getResultList();
        return ResponseBuilder.buildGet(result);
    }
    
    @GET
    @Path("{id}")
    @Produces({ MediaType.APPLICATION_JSON})
    public Response find(@PathParam("id") Integer id) {
        return ResponseBuilder.buildGet(super.get(id));
    }

    @GET
    @Produces({ MediaType.APPLICATION_JSON})
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
