/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.helmo.al.natadmin.entity.Bird;
import com.helmo.al.natadmin.security.RequestBuilder;
import java.lang.reflect.Type;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:BirdsService [birds]<br>
 * USAGE:
 * <pre>
 *        BirdsClient client = new BirdsClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author foers
 */
public class BirdsClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://192.168.128.13:8081/NataRest/api";
    private static final Gson GSON = new Gson();
    
    
    public BirdsClient() {
        client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI).path("birds");
    }

    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }

    public void edit(Object requestEntity, String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T find(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findRange(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void create(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void remove(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
    }

    public List<Bird> findAlll() throws ClientErrorException {
        WebTarget resource = webTarget;
        //String stringResult = RequestBuilder.Build(resource).get().readEntity(String.class);
        String stringResult = resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get().readEntity(String.class);
        return GSON.fromJson(stringResult, new TypeToken<List<Bird>>(){}.getType());
    }

    public void close() {
        client.close();
    }
}
