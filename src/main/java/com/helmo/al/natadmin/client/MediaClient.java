///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.helmo.al.natadmin.client;
//
//import com.helmo.al.natadmin.entity.Media;
//import com.helmo.al.natadmin.security.RequestBuilder;
//import java.util.List;
//import javax.ws.rs.core.GenericType;
//import javax.ws.rs.core.Response;
//
///**
// *
// * @author foers
// */
//public class MediaClient extends BaseClient {
//    
//    public MediaClient() {
//        super("media");
//    }
//    
//    public Media find(int mediaID) {
//        Response r = RequestBuilder.Build(getRessource().path(String.valueOf(mediaID)))
//                .get();
//        return ValidateHTTP(r, Media.class);
//    }
//    
//    public List<Media> findAll() {
//        Response r = RequestBuilder.Build(getRessource())
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    public List<Media> findBySession(int sesionID) {
//        Response r = RequestBuilder.Build(getRessource().path("bySession/" + sesionID))
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    public List<Media> byType(MediaType type) {
//        Response r = RequestBuilder.Build(getRessource().path("byMedia/" + type))
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    /*******************************************/
//    /*****             PENDING            ******/
//    /*******************************************/
//    public Media pending(int mediaID) {
//        Response r = RequestBuilder.Build(getRessource().path("pending/" + mediaID))
//                .get();
//        return ValidateHTTP(r, Media.class);
//    }
//    
//    public List<Media> pending() {
//        Response r = RequestBuilder.Build(getRessource().path("pending"))
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    public List<Media> pendingBySession(int sesionID) {
//        Response r = RequestBuilder.Build(getRessource().path("pending/all/" + sesionID))
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    public List<Media> pendingByUser(int userID) {
//        Response r = RequestBuilder.Build(getRessource().path("pending/" + userID))
//                .get();
//        return(r.getStatusInfo() == Response.Status.OK)
//            ? r.readEntity(new GenericType<List<Media>>(){})
//            : null;
//    }
//    
//    @Override
//    protected void finalize() throws Throwable {
//        close();
//        super.finalize();
//    }
//    
//    /******************************************/
//    /*****   Enum Helper For MediaType   ******/
//    /******************************************/
//    
//    public static enum MediaType {
//        TEXT("text"),
//        PICTURE("image"),
//        AUDIO("audio"),
//        VIDEO("video");
//        
//        private final String value;
//        
//        private MediaType(String value) {
//            this.value = value;
//        }
//
//        public String getValue() {
//            return value;
//        }
//    }
//}
