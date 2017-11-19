/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.UserClient;
import com.helmo.al.natadmin.entity.User;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class UserHandler extends BaseHandler<User>{
    
    public UserHandler() {
        super(User.class, new UserClient());
    }

    @Override
    public List<User> all() {
        return super.all(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User find(String id) {
        return super.find(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
