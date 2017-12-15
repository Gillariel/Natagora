/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.view;

import java.util.Date;

/**
 *
 * @author foers
 */
public class ObsMedia {
    private String url;
    private String text;
    private String type;
    private String session_id;
    private String validated;
    private String pseudo;
    private String date;

    public ObsMedia() {
    }

    public ObsMedia(String Url, String Text, String Type, String Sesisons_ID, String Validated, String Pseudo, String Date) {
        this.url = Url;
        this.text = Text;
        this.type = Type;
        this.session_id = Sesisons_ID;
        this.validated = Validated;
        this.pseudo = Pseudo;
        this.date = Date;
    }

    public String getDate() {
        return date;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getSession_id() {
        return session_id;
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

    public String getValidated() {
        return validated;
    }

    public void setDate(String Date) {
        this.date = Date;
    }

    public void setPseudo(String Pseudo) {
        this.pseudo = Pseudo;
    }

    public void setSession_id(String Session_id) {
        this.session_id = Session_id;
    }

    public void setText(String Text) {
        this.text = Text;
    }

    public void setType(String Type) {
        this.type = Type;
    }

    public void setUrl(String Url) {
        this.url = Url;
    }

    public void setValidated(String Validated) {
        this.validated = Validated;
    }
    
    
}
