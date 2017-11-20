/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Joke;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class JokeClient {
    private final WebTarget webTarget;
    private final Client client;
    private static final String BASE_URI = "https://08ad1pao69.execute-api.us-east-1.amazonaws.com/dev/random_ten";

    public JokeClient() {
        client = javax.ws.rs.client.ClientBuilder.newBuilder().build();
        webTarget = client.target(BASE_URI);
    }
    
    public List<Joke> random() {
        return webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .get(Response.class)
                .readEntity(new GenericType<List<Joke>>() {});
    }
}
