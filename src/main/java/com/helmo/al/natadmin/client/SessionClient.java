/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Session;
import com.helmo.al.natadmin.security.Global;
import com.helmo.al.natadmin.view.MediaBySession;
import com.helmo.al.natadmin.view.MediaView;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author foers
 */
public class SessionClient extends BaseClient<Session> {
    
    public SessionClient() {
        super(Session.class, new GenericType<List<Session>>() {}, "sessions");
    }
    
    public List<Object[]> mediaBySession(String id) {
        return getRessource().path("observationsMedia/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(new GenericType<List<Object[]>>(){});
    }
    
    public List<String> mediaUrlBySession(String id) {
        String res = getRessource().path("observationsMedia/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
        
        JSONArray list = null;
        try {
            list = new JSONArray(res);
        } catch (JSONException ex) {
            Logger.getLogger(SessionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i <= list.length() - 1; i++){
            try{
                result.add(list.getJSONArray(i).getString(0));
            }catch(Exception e){
                return result;
            }
        }
        return result;
    }
    
    public List<String> mediaBySession3(String id) {
        String res = getRessource().path("observationsMedia/" + id)
                .request(MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY)
                .get(Response.class)
                .readEntity(String.class);
        
        JSONArray list = null;
        try {
            list = new JSONArray(res);
        } catch (JSONException ex) {
            Logger.getLogger(SessionClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i <= 2; i++){
            try{
                result.add(list.getJSONArray(i).getString(0));
            }catch(Exception e){
                return result;
            }
        }
        return result;
    }
}
