/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Media;
import com.helmo.al.natadmin.security.RequestBuilder;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 * @param <T> The subclass entity
 */
public abstract class BaseClient<T> {
    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://192.168.128.13:8081/NataRest/api/";

    private final Class<T> entityClass;
    private final GenericType listClass;
    
    public BaseClient(Class<T> entityClass, GenericType g, String path) {
        this.entityClass = entityClass;
        this.listClass = g;
        client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI + path);
    }
    
    
    public T get(String id) throws ClientErrorException {
        webTarget.path("/" + id);
        return RequestBuilder.execute(webTarget, this.getTypeClass());
    }
    
    public List<T> getAll() throws ClientErrorException {
        return RequestBuilder.execute(webTarget, listClass);
    }
    
    public String count() throws ClientErrorException {
        webTarget.path("/count");
        return String.valueOf(RequestBuilder.executeCount(webTarget));
    }
    
    protected <T> T ValidateHTTP(Response r, Class<T> type){
        return(r.getStatusInfo() == Response.Status.OK)
            ? r.readEntity(type)
            : null;
    }
    
    protected WebTarget getRessource(){
        return this.webTarget;
    }
    
    protected Class<T> getTypeClass() {
        return this.entityClass;
    }
    
    public GenericType getListClass() {
        return this.listClass;
    }
    
    public void close(){
        client.close();
    }
}
