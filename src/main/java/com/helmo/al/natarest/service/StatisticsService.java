/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.util.ResponseBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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

@Path("stats")
public class StatisticsService {
    
    private final EntityManager em;
    
    public StatisticsService() {
        em = AbstractDao.getEntityManager();
    }
    
    
    @GET
    @Path("birds")
    @Produces({MediaType.APPLICATION_JSON})
    public Response birds() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.BIRDS, 0));
    }
    
    @GET
    @Path("comments")
    @Produces({MediaType.APPLICATION_JSON})
    public Response comments() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.COMMENTS, 0));
    }

    @GET
    @Path("media")
    @Produces({MediaType.APPLICATION_JSON})
    public Response media() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.MEDIA, 0));
    }
    
    @GET
    @Path("observations")
    @Produces({MediaType.APPLICATION_JSON})
    public Response observations() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.OBSERVATIONS, 0));
    }
    
    @GET
    @Path("sessions")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sessions() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.SESSIONS, 0));
    }
    
    @GET
    @Path("users")
    @Produces({MediaType.APPLICATION_JSON})
    public Response users() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.USERS, 0));
    }
    
    @GET
    @Path("lastUsers")
    @Produces({MediaType.APPLICATION_JSON})
    public Response lastUsers() {
        return ResponseBuilder.buildGet(trySearch(StatQueries.LAST_USERS, 0));
    }
    
    @GET
    @Path("comments/{forum_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response commentsByForums(@PathParam("forum_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.COMMENTS_BY_FORUMS, id));
    }
    
    @GET
    @Path("media/{type_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response mediaByType(@PathParam("type_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.MEDIA_BY_TYPE, id));
    }
    
    @GET
    @Path("birds/{bird_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response seeBirds(@PathParam("bird_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.SEE_BIRD, id));
    }
    
    @GET
    @Path("observations/{session_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response observationsBySesion(@PathParam("session_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.OBSERVATION_BY_SESSION, id));
    }
    
    @GET
    @Path("observations/byUser/{user_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response observationsByUser(@PathParam("user_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.OBSERVATION_SESSION_BY_USER, id));
    }
    
    @GET
    @Path("sessions/{user_id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response sessionsByUser(@PathParam("user_id") Integer id) {
        return ResponseBuilder.buildGet(trySearch(StatQueries.SESSIONS_BY_USER, id));
    }
    
    
    
    private long trySearch(StatQueries query, int id){
        try{
            Query q = (id > 0) 
                    ? em.createNativeQuery(query.getQuery()).setParameter("id", id)
                    : em.createNativeQuery(query.getQuery());
            return (long) q.getSingleResult();
        } catch(Exception e){
            return 0;
        }
    }
    
    public enum StatQueries {
        BIRDS("SELECT Number FROM Count_Birds"),
        COMMENTS("SELECT Number FROM Count_Comments"),
        MEDIA("SELECT Number FROM Count_Media"),
        OBSERVATIONS("SELECT Number FROM Count_Observations"),
        SESSIONS("SELECT Number FROM Count_Sessions"),
        USERS("SELECT Number FROM Count_Users"),
        LAST_USERS("SELECT Number FROM Last_New_Users"),
        COMMENTS_BY_FORUMS("SELECT Number FROM Count_Forum_Comments WHERE Forum_ID = #id"),
        MEDIA_BY_TYPE("SELECT Number FROM Count_Media_By_Type WHERE Type_ID = #id"),
        SEE_BIRD("SELECT Number FROM Count_Number_See_Bird WHERE Bird_ID = #id"),
        OBSERVATION_BY_SESSION("SELECT Number FROM Count_Observations_Session WHERE Sessions_ID = #id"),
        OBSERVATION_SESSION_BY_USER("SELECT Number FROM Count_Observations_Sessions_User WHERE User_ID = #id"),
        SESSIONS_BY_USER("SELECT Number FROM Count_User_Sessions WHERE User_ID = #id");
        
        private final String query;
        
        private StatQueries(String query) {
            this.query = query;
        }

        public String getQuery() {
            return query;
        }
    } 
}
