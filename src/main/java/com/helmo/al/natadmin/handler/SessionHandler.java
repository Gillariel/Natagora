/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.SessionClient;
import com.helmo.al.natadmin.entity.Session;
import com.helmo.al.natadmin.view.MediaView;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class SessionHandler extends BaseHandler<Session>{
    
    public SessionHandler() {
        super(Session.class, new SessionClient());
    }

    @Override
    public List<Session> all() {
        return super.all();
    }

    @Override
    public Session find(String id) {
        return super.find(id);
    }
    
    public List<Object[]> mediaBySession(String id) {
        List<Object[]> media = ((SessionClient)client).mediaBySession(id);
        return media;
    }
    
}
