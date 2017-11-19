/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.User;
import javax.ws.rs.core.GenericType;
import java.util.List;

/**
 *
 * @author foers
 */
public class UserClient extends BaseClient<User> {
    
    public UserClient() {
        super(User.class, new GenericType<List<User>>(){}, "users");
    }
    
}
