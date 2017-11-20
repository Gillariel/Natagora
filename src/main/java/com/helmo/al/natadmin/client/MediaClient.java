/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Media;
import com.helmo.al.natadmin.security.RequestBuilder;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author foers
 */
public class MediaClient extends BaseClient {
    
    public MediaClient() {
        super(Media.class, new GenericType<List<Media>>(){}, "media");
    }
    
    public Media find(int id) {
        return RequestBuilder.execute(getRessource().path("/" + id), Media.class);
    }
    
    public List<Media> findAll() {
        return super.getAll();
    }
    
    /*public List<Media> findBySession(int sesionID) {
        Response r = RequestBuilder.Build(getRessource().path("bySession/" + sesionID))
                .get();
        return(r.getStatusInfo() == Response.Status.OK)
            ? r.readEntity(new GenericType<List<Media>>(){})
            : null;
    }
    
    public List<Media> byType(MediaType type) {
        Response r = RequestBuilder.Build(getRessource().path("byMedia/" + type))
                .get();
        return(r.getStatusInfo() == Response.Status.OK)
            ? r.readEntity(new GenericType<List<Media>>(){})
            : null;
    }/*
    
    /*******************************************/
    /*****             PENDING            ******/
    /*******************************************/
    
    public List<Media> pending() {
        return RequestBuilder.execute(getRessource().path("/pending"), getListClass());
    }
    
    public List<Media> pendingBySession(int sesionID) {
        return RequestBuilder.execute(getRessource().path("pending/all/" + sesionID), getListClass());
    }
    
    public List<Media> pendingByUser(int userID) {
        return RequestBuilder.execute(getRessource().path("pending/" + userID), getListClass());
    }
    
    public String history() {
        return RequestBuilder.execute(getRessource().path("history/created"));
    }
    
    public String historyPending() {
        return RequestBuilder.execute(getRessource().path("history/pending"));
    }
    
    public String countByType() {
        return RequestBuilder.execute(getRessource().path("count/type"));
    }
    
    /******************************************/
    /*****   Enum Helper For MediaType   ******/
    /******************************************/
    
    public static enum MediaType {
        TEXT("text"),
        PICTURE("image"),
        AUDIO("audio"),
        VIDEO("video");
        
        private final String value;
        
        private MediaType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
