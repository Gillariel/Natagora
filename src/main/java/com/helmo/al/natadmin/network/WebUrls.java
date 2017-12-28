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
public enum WebUrls {
    INDEX(""),
    HOME("home"),
    LOGIN("login"),
    SIGNIN("login/signin"),
    MY_ACCOUNT("my"),
    BIRDS("birds");

    private static final String BASE = "http://192.168.128.13/~e140577/NataWeb/webroot/index.php/";
    
    private final String url;
    
    WebUrls(String url) {
        this.url = BASE + url;
    }

    public String getUrl() {
        return url;
    }
    
    public static List<String> getAsList() {
        List<String> results = new ArrayList<>();
        List<WebUrls> urls = Arrays.asList(WebUrls.values());
        for(WebUrls u : urls)
            results.add(u.getUrl());
        return results;
    }
}
