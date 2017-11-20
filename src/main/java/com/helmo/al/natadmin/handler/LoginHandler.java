/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.UserClient;
import com.helmo.al.natadmin.entity.User;
import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author foers
 */
@ManagedBean
@RequestScoped
public class LoginHandler {
    
    /**
     * For Login
     */
    private String username;
    private String passwd;
    private String rememberMe;

    public LoginHandler() {
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswd() { return passwd; }
    public void setPasswd(String passwd) { this.passwd = passwd; }
    public String getRememberMe() { return rememberMe; }
    public void setRememberMe(String rememberMe) { this.rememberMe = rememberMe; }

    public void login() {
        User loggedUser = new UserClient().login(username, passwd);
        if(loggedUser != null){
            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            
            UserSession user = (session != null) ? (UserSession)session.getAttribute("user") : new UserSession();
            if(user == null)
                user = new UserSession(loggedUser);
            try{
                user.setUser(loggedUser);
                session.setAttribute("user", user);
            } catch(Exception e) { e.printStackTrace(); }

            HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
            String contextPath = origRequest.getContextPath();
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect(contextPath  + "/dashboard.xhtml");
            } catch (IOException e) { e.printStackTrace(); }
        } else {
            return;
        }
    }
    
    /**
     * for Reset Passwd
     */
    private String mail;

    public String getMail() { return mail; }
    public void setMail(String mail) { this.mail = mail; }
    
    public void reset() {
        return;
    }
}
