/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.User;
import com.helmo.al.natadmin.security.Global;
import com.helmo.al.natadmin.security.RequestBuilder;
import com.helmo.al.natadmin.util.CompletelyDeprecateSSLDestroyerDueToBadServer;
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
public class StatisticsClient extends BaseClient<String> {
    /*private final WebTarget webTarget;
    private final Client client;
*/
    public StatisticsClient() {
        super(String.class, new GenericType<List<String>>(){}, "stats/");
        //client = CompletelyDeprecateSSLDestroyerDueToBadServer.DestroyEverything();
        //webTarget = client.target(Global.BASE_URL + "stats/");
    }

    
    
    /*public String get(String path) throws ClientErrorException {
        WebTarget t = webTarget.path(path);
        return RequestBuilder.execute(t);
    }*/
    
    public String getByID(String path, int ID) throws ClientErrorException {
        WebTarget t = getRessource().path(path + ID);
        return t.request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
    }
}
