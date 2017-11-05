/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import com.google.gson.Gson;
import java.util.Collection;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class GSONParser {
    
    public static String Parse(Object entity){
        return new Gson().toJson(entity, entity.getClass());
    }
    
    public static String Parse(Collection<Object> entities){
        return new Gson().toJson(entities, entities.getClass());
    }
    
    public static Response BuildRepsonse(Object entity){
        return Response.ok(new Gson().toJson(entity, entity.getClass())).build();
    }
    
    public static Response BuildRepsonse(Collection<Object> entities){
        return Response.ok(new Gson().toJson(entities, entities.getClass())).build();
    }
}
