/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.view;

/**
 *
 * @author foers
 */
public class MediaBySession {
    String url;
    String text;
    String type;
    int sessionID;
    String comment;
    String name;
    double latitude;
    double longitude;
    boolean validated;
    String pseudo;
    int date;

    public MediaBySession() {
    }

    public MediaBySession(String url, String text, String type, int sessionID, String comment, String name, double latitude, double longitude, boolean validated, String pseudo, int date) {
        this.url = url;
        this.text = text;
        this.type = type;
        this.sessionID = sessionID;
        this.comment = comment;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.validated = validated;
        this.pseudo = pseudo;
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public int getDate() {
        return date;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getName() {
        return name;
    }

    public String getPseudo() {
        return pseudo;
    }

    public int getSessionID() {
        return sessionID;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getUrl() {
        return url;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setSessionID(int sessionID) {
        this.sessionID = sessionID;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
        
}
