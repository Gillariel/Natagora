/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.helmo.al.natarest.entity.Observation;
import java.util.Collection;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class GSONParser {
    
    private static final Gson GSON = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .setExclusionStrategies(new JsonExcludeStrategy(Observation.class))
            .serializeNulls()
            .create();
    
    public static String Parse(Object entity){
        return GSON.toJson(entity, entity.getClass());
    }
    
    public static String Parse(Collection<Object> entities){
        return GSON.toJson(entities, entities.getClass());
    }
    
    public static Response BuildRepsonse(Object entity){
        return Response.ok(GSON.toJson(entity, entity.getClass())).build();
    }
    
    public static Response BuildRepsonse(Collection<Object> entities){
        return Response.ok(GSON.toJson(entities, entities.getClass())).build();
    }
    
    public static Response buildCircularResponse(Object entity){
        GsonBuilder b = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .setExclusionStrategies(new JsonExcludeStrategy(entity.getClass()))
                        .serializeNulls();
        
        new GraphAdapterBuilder()
                    .addType(entity.getClass())
                    .registerOn(b);
        
        return Response.ok(b.create().toJson(entity)).build();
    }
    
    public static Response buildCircularResponse(Collection<Object> entities){
        GsonBuilder b = new GsonBuilder()
                        .setDateFormat("yyyy-MM-dd HH:mm:ss")
                        .setExclusionStrategies(new JsonExcludeStrategy(entities.getClass()))
                        .serializeNulls();
        
        new GraphAdapterBuilder()
                    .addType(entities.getClass())
                    .registerOn(b);
        
        return Response.ok(b.create().toJson(entities)).build();
    }
}
