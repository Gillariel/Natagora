/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import java.util.Collection;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class ResponseBuilder {
    public static Response buildBlank(boolean condition) {
        return (!condition)
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.ok().build();
    }
    
    public static Response buildGet(Object entity) {
        return (entity == null) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.ok(JacksonParser.Parse(entity)).build();
    }
    
    public static Response buildGet(Collection<Object> entities) {
        return (entities == null || entities.isEmpty()) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.ok(JacksonParser.Parse(entities)).build();
    }
    
    /*public static Response buildCircularGet(Object entity) {
        return (entity == null) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : GSONParser.buildCircularResponse(entity);
    }
    
    public static Response buildCircularGet(Collection<Object> entities) {
        return (entities == null || entities.isEmpty()) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : GSONParser.buildCircularResponse(entities);
    }*/
    
    public static Response buildDelete(boolean result) {
        return (!result) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.status(Response.Status.CREATED).build();
    }
    
    public static Response buildPut(boolean result) {
        return (!result) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.status(Response.Status.CREATED).build();
    }
    
    public static Response buildPost(boolean result) {
        return (!result) 
            ? Response.status(Response.Status.NOT_FOUND).build()
            : Response.status(Response.Status.CREATED).build();
    }
}
