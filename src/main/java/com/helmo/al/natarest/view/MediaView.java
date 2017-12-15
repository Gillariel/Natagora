/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.view;

/**
 *
 * @author foers
 */
public class MediaView {
    private String url;
    private String text;
    private String sesions_id;

    public MediaView() {
    }

    public MediaView(String url, String text, String sesions_id) {
        this.url = url;
        this.text = text;
        this.sesions_id = sesions_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSesions_id() {
        return sesions_id;
    }

    public void setSesions_id(String sesions_id) {
        this.sesions_id = sesions_id;
    }
    
    
}
