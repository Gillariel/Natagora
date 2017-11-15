/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.AnnotationIntrospectorPair;
import com.fasterxml.jackson.databind.introspect.JacksonAnnotationIntrospector;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationIntrospector;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author foers
 */
public class Jackson {
    private static final ObjectMapper Jackson = new ObjectMapper()
            .setAnnotationIntrospector(new AnnotationIntrospectorPair(new JacksonAnnotationIntrospector(), new JaxbAnnotationIntrospector()));
    
    public static <T> T DeserializeAsObject(String json, Class<T> t){
        try{
            return Jackson.readValue(json, t);
        } catch(IOException e){
            return null;
        }
    }
    
    public static <T> ArrayList<T> DeserializeAsList(String json, Class<T> t){
        try{
            return Jackson.readValue(json, TypeFactory.defaultInstance().constructCollectionType(ArrayList.class, t));
        } catch(IOException e){
            return null;
        }
    }
    
    public static <T> LinkedList<T> DeserializeAsLinkedList(String json, Class<T> t){
        try{
            return Jackson.readValue(json, TypeFactory.defaultInstance().constructCollectionType(LinkedList.class, t));
        } catch(IOException e){
            return null;
        }
    }
}
