/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.MediaClient;
import com.helmo.al.natadmin.entity.Media;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Maude Foerster
 */

@ManagedBean
@RequestScoped
public class PendingHandler extends BaseHandler<Media> {

    public PendingHandler() {
        super(Media.class, new MediaClient());
    }
    
    @Override
    public List<Media> all(){
        return ((MediaClient) client).pending();
    }
    
    public String history() {
        return ((MediaClient) client).history();
    }
    
    public String historyPending() {
        return ((MediaClient) client).historyPending();
    }
    
    public String countByType() {
        return ((MediaClient) client).countByType();
    }
    /**
     * If Error of type "BaseHandler attribute modifier public is not accessible"
     * Override the method from BaseHandler to return explicit type like commented example below
     */ 
    /*@Override
    public List<Media> all() {
        /**
         * This line should be use instead of current one.
         * Not use now because REST doesn't currently contains /pending/* methods 
         * 
         * return super.all();
         */
        /*return new MediaClient().findAll();
    }*/
}
