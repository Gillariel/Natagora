/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.security;

import java.util.List;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class RequestBuilder {

    /**
     *
     * @param t The webTarget object
     * @return The Request with correct headers
     */
    private static Builder Build(WebTarget t){
        return t.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .acceptEncoding("UTF-8");
    }
    
    public static Long execute(WebTarget target){
        return Build(target)
                .get(Response.class)
                .readEntity(Long.class);
    }
    
    public static <T> T execute(WebTarget target, Class<T> t){
        T result = Build(target)
                    .get(Response.class)
                    .readEntity(t);
        return(result != null)
            ? result
            : null;
    }
    
    public static <T> List<T> execute(WebTarget target, GenericType<List<T>> t){
        List<T> results = Build(target)
                            .get(Response.class)
                            .readEntity(t);
        return(results.size() > 0)
            ? results
            : null;
    }

    public static int executeCount(WebTarget target) {
        return Build(target)
                .get(Response.class)
                .readEntity(Integer.class);
    }
    
    public static void remove(WebTarget target, Object o) {
        Build(target)
                .delete(o.getClass());
    }
}
