/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Bird;
import com.helmo.al.natadmin.security.Global;
import com.helmo.al.natadmin.security.RequestBuilder;
import com.helmo.al.natadmin.util.Jackson;
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
 */
public class BirdsClient extends BaseClient<Bird>{
     
    public BirdsClient() {
        super(Bird.class, new GenericType<List<Bird>>(){}, "birds");
    }

    public String count() throws ClientErrorException {
        return super.count();
    }

    public Bird find(int id) {
        return RequestBuilder.execute(getRessource().path("/"+id), Bird.class);
    }

    public List<Bird> findAll() {
        return super.getAll();
    }
    
    public String top5() {
        return super.getRessource().path("top")
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
    
    public String history() {
        return super.getRessource().path("history")
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
}
