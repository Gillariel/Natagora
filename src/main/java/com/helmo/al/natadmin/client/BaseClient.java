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
    private static final String BASE_URI = "http://127.0.0.1:8081/NataRest/api/";

    /**
     *  The java class of the entity
     */
    private final Class<T> entityClass;
    
    /**
     * The generic Type of the entity implemented List, use for deserialize
     */
    private final GenericType listClass;
    
    public BaseClient(Class<T> entityClass, GenericType g, String path) {
        this.entityClass = entityClass;
        this.listClass = g;
        client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI + path);
    }
    
    /**
     * @param id Th ID of the entity in the database
     * @return The entity matching or null
     * @throws ClientErrorException 
     */
    public T get(String id) throws ClientErrorException {
        webTarget.path("/" + id);
        return RequestBuilder.execute(webTarget, this.getTypeClass());
    }
    
    /**
     * @return Simply all entities of this type, no matter any conditions
     * @throws ClientErrorException 
     */
    public List<T> getAll() throws ClientErrorException {
        return RequestBuilder.execute(webTarget, listClass);
    }
    
    /**
     * @return The number of existing entities of this type
     * @throws ClientErrorException 
     */
    public String count() throws ClientErrorException {
        webTarget.path("/count");
        return String.valueOf(RequestBuilder.executeCount(webTarget));
    }
    
    /**
     * @param id The ID of the entity in the database
     * @param path The custom resource's path (beginning with "/") 
     * @return The matching entity
     * @throws ClientErrorException 
     */
    public T getCustomFromId(String id, String path) throws ClientErrorException {
        webTarget.path(path);
        return RequestBuilder.execute(webTarget, this.getTypeClass());
    }
    
    /**
     * @param path The custom resource's path beginning with "/"
     * @return The List of result
     * @throws ClientErrorException 
     */
    public List<T> getAllFromCustomPath(String path) throws ClientErrorException {
        webTarget.path(path);
        return RequestBuilder.execute(webTarget, listClass);
    }
    
    public <T> T ValidateHTTP(Response r, Class<T> type) {
        return(r.getStatusInfo() == Response.Status.OK)
            ? r.readEntity(type)
            : null;
    }
    
    public WebTarget getRessource(){
        return this.webTarget;
    }
    
    /**
     * @return The java class of the entity
     */
    public Class<T> getTypeClass() {
        return this.entityClass;
    }
    
    /**
     * @return The generic Type of the entity implemented List, use for deserialize
     */
    public GenericType getListClass() {
        return this.listClass;
    }
    
    public void close(){
        client.close();
    }
}
