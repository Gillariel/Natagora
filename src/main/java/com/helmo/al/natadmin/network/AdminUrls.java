package com.helmo.al.natadmin.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author foers
 */
public enum AdminUrls {
    
    INDEX("dashboard"),
    BIRDS("data/birds"),
    PENDING("data/pending"),
    REPORTED("data/reported"),
    SESSIONS("data/sessions"),
    USERS("data/users"),
    STATS_BIRDS("statistics/birds"),
    STATS_FORUMS("statistics/forums"),
    STATS_MEDIA("statistics/media"),
    STATS_USERS("statistics/users"),
    LOGIN("users/login"),
    USERS_PROFILE("users/profile"),
    USERS_ACCOUNT("users/account"),
    USERS_INBOX("users/inbox");
    

    private static final String BASE = "https://192.168.128.12:8181/NatAdmin/";
    
    private final String url;
    
    AdminUrls(String url) {
        this.url = BASE + url;
    }

    public String getUrl() {
        return url;
    }
    
    public static List<String> getAsList() {
        List<String> results = new ArrayList<>();
        List<AdminUrls> urls = Arrays.asList(AdminUrls.values());
        for(AdminUrls u : urls)
            results.add(u.getUrl());
        return results;
    }
}
