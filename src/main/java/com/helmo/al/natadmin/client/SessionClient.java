/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.Session;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author foers
 */
public class SessionClient extends BaseClient<Session> {
    
    public SessionClient() {
        super(Session.class, new GenericType<List<Session>>() {}, "sessions");
    }
    
}
