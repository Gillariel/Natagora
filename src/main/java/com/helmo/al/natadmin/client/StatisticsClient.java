/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.security.RequestBuilder;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author foers
 */
public class StatisticsClient {
    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "http://127.0.0.1:8081/NataRest/api/stats/";

    public StatisticsClient() {
        client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI);
    }

    public String get(String path) throws ClientErrorException {
        WebTarget t = webTarget.path(path);
        return RequestBuilder.execute(t);
    }
    
    public String getByID(String path, int ID) throws ClientErrorException {
        WebTarget t = webTarget.path(path + ID);
        return RequestBuilder.execute(t);
    }
}
