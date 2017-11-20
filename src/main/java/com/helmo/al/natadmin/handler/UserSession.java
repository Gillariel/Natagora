/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.entity.Role;
import com.helmo.al.natadmin.entity.User;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@SessionScoped
public class UserSession implements Serializable {
    User currentUser;
    boolean rememberMe;
    
    public UserSession() {
        this.currentUser = new User();
    }

    public UserSession(User u) {
        this.currentUser = u;
    }

    public User getUser() {
        return currentUser;
    }

    public void setUser(User u) {
        this.currentUser = u;
    }
    
    public int getId() { return this.currentUser.getId(); }
    public String getName() { return this.currentUser.getName(); }
    public String getPassword() { return this.currentUser.getPassword(); }
    public String getForName() { return this.currentUser.getForname(); }
    public String getFullName() { return this.currentUser.getFullName(); }
    public String getUsername() { return this.currentUser.getPseudo(); }
    public String getMail() { return this.currentUser.getMail(); }
    public Role getRole() { return this.currentUser.getRole(); }
    public boolean isRememberMe() { return rememberMe; }
    
    public void setName(String name) { this.currentUser.setName(name); }
    public void setPassword(String passwd) { this.currentUser.setPassword(passwd); }
    public void setForName(String forname) { this.currentUser.setForname(forname); }
    public void setUsername(String username) { this.currentUser.setPseudo(username); }
    public void setMail(String mail) { this.currentUser.setMail(mail); }
    public void setRole(Role role) { this.currentUser.setRole(role); }
    public void setRememberMe(boolean rememberMe) { this.rememberMe = rememberMe; }
    
    public void setFullName(String fullname) throws IllegalArgumentException { 
        String[] split = fullname.split(" ");
        if(split.length == 2){
            this.currentUser.setName(split[0]);
            this.currentUser.setForname(split[1]);
        } else {
            throw new IllegalArgumentException("FullName must be of format \"{Name} space {forname}\"!");
        }
    }
}
