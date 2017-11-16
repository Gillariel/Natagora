package com.helmo.al.natadmin.network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author foers
 */
public enum AdminUrls {
    
    INDEX(""),
    BIRDS("data/birds.xhtml"),
    PENDING("data/pending.xhtml"),
    REPORTED("data/reported.xhtml"),
    SESSIONS("data/sessions.xhtml"),
    USERS("data/users.xhtml"),
    STATS_BIRDS("statistics/birds.xhtml"),
    STATS_FORUMS("statistics/forums.xhtml"),
    STATS_MEDIA("statistics/media.xhtml"),
    STATS_USERS("statistics/users.xhtml"),
    LOGIN("users/login.xhtml"),
    USERS_PROFILE("users/profile.xhtml"),
    USERS_ACCOUNT("users/account.xhtml"),
    USERS_INBOX("users/inbox.xhtml");
    

    private static final String BASE = "http://127.0.0.1:8080/NatAdmin/";
    
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
