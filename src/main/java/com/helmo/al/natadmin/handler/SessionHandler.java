/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.SessionClient;
import com.helmo.al.natadmin.entity.Session;
import com.helmo.al.natadmin.view.MediaBySession;
import com.helmo.al.natadmin.view.MediaView;
import java.io.Console;
import java.util.ArrayList;
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

    public List<Session> last10() {
        List<Session> top =  new ArrayList<>();
        List<Session> sessions = super.all();
        for(int i = sessions.size() - 1; i >= sessions.size() - 10; i--) {
            try{
                top.add(sessions.get(i));
            }catch(Exception e){
                return top;
            }
        }
        return top;
    }
    
    @Override
    public Session find(String id) {
        return super.find(id);
    }
    
    public List<Object[]> mediaBySession(String id) {
        List<Object[]> media = ((SessionClient)client).mediaBySession(id);
        return media;
    }
    
    public List<String> mediaUrlBySession(String id) {
        List<String> media = ((SessionClient)client).mediaUrlBySession(id);
        return media;
    }
    
    public List<String> top3MediaBySession(String id) {
        List<String> media = ((SessionClient)client).mediaBySession3(id);
        return media;
    }
    
}
