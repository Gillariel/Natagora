/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author foers
 */
public enum Urls {
    
    INDEX(""),
    BIRDS("api/birds"),
    COMMENTS("api/comments"),
    FORUMS("api/forums"),
    MEDIA("api/media"),
    MEDIATYPE("api/mediatype"),
    NOTES("api/notes"),
    OBSERVATIONS("api/observations"),
    ROLES("api/roles"),
    SESSIONS("api/sessions"),
    TAGS("api/tags"),
    USERS("api/users"),
    WRONG("api/wrong");

    private static final String BASE = "http://192.168.128.13:8081/NataRest/";
    
    private final String url;
    
    Urls(String url) {
        this.url = BASE + url;
    }

    public String getUrl() {
        return url;
    }
    
    public static List<String> getAsList() {
        List<String> results = new ArrayList<>();
        List<Urls> urls = Arrays.asList(Urls.values());
        for(Urls u : urls)
            results.add(u.getUrl());
        return results;
    }
}
