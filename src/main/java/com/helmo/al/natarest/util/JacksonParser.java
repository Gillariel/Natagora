/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import java.util.Collection;
import javax.ws.rs.core.Response;

/**
 *
 * @author foers
 */
public class JacksonParser {
    private static final ObjectMapper Jackson = new ObjectMapper()
            .setAnnotationIntrospector(new AnnotationIntrospectorPair(new JacksonAnnotationIntrospector(), new JaxbAnnotationIntrospector()));
    
    public static String Parse(Object entity){
        try{
            return Jackson.writeValueAsString(entity);
        } catch(JsonProcessingException e) {
            return "";
        }
    }
    
    public static String Parse(Collection<Object> entities){
        try{
            return Jackson.writeValueAsString(entities);
        } catch(JsonProcessingException e) {
            return "";
        }
    }
    
    public static Response BuildRepsonse(Object entity){
        try{
            return Response.ok(Jackson.writeValueAsString(entity)).build();
        } catch(JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    public static Response BuildRepsonse(Collection<Object> entities){
        try{
            return Response.ok(Jackson.writeValueAsString(entities)).build();
        } catch(JsonProcessingException e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
}
