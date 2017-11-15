///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.helmo.al.natadmin.client;
//
//import com.helmo.al.natadmin.security.RequestBuilder;
//import java.util.HashMap;
//import java.util.Map;
//import javax.ws.rs.core.MultivaluedHashMap;
//
//
///**
// *
// * @author foers
// */
//public class AuthClient extends BaseClient {
//    
//    public AuthClient(String path) {
//        super(path);
//    }
//    
//    /**
//     * @see Considering HTTPS to count on SSL encryption
//     * @param username
//     * @param mdp
//     * @return the result of the login
//     */
//    public boolean authenticate(String username, String mdp) {
//        MultivaluedHashMap<String,Object> heads = new MultivaluedHashMap<>();
//        heads.add("username", username);
//        heads.add("password", mdp);
//        return RequestBuilder.Build(getRessource().path("login"))
//                .headers(heads)
//                .get(Boolean.TYPE);
//    }
//    
//    
//}
