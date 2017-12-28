/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.User;
import com.helmo.al.natadmin.security.Global;
import com.helmo.al.natadmin.security.RequestBuilder;
import javax.ws.rs.core.GenericType;
import java.util.List;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class UserClient extends BaseClient<User> {
    
    public UserClient() {
        super(User.class, new GenericType<List<User>>(){}, "users");
    }
    
    public User getByUsername(String username) {
        return RequestBuilder.execute(getRessource().path("/byUsername/" + username), User.class);
                
    }
    
    public User login(String username, String passwd) {
        WebTarget t = getRessource().path("/loginAdmin/" + username);
        return t.request()
                    .header("api-key", Global.API_KEY)
                    .header("passwd", passwd)
                    .accept("Content-Type", "application/json")
                    .get(Response.class)
                    .readEntity(User.class);
    }
    
    public String history() {
        WebTarget t = super.getRessource().path("/history");
        return t
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
    
    public String byRole() {
        WebTarget t = super.getRessource().path("/byRole");
        return t
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
    
    public String vsFb() {
        WebTarget t = super.getRessource().path("/vsFb");
        return t
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
}
