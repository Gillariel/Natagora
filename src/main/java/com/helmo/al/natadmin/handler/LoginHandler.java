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
    private boolean rememberMe;

    public LoginHandler() {
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPasswd() { return passwd; }
    public void setPasswd(String passwd) { this.passwd = passwd; }
    public boolean isRememberMe() { return rememberMe; }
    public void setRememberMe(boolean rememberMe) { this.rememberMe = rememberMe; }

    public void login() {
        User loggedUser = new UserClient().login(username, passwd);
        //System.out.println(loggedUser.BetterStringView());
        if(loggedUser != null){
            
            FacesContext context = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
            
            /*UserSession user = (session != null) ? (UserSession)session.getAttribute("user") : new UserSession();
            if(user == null)
                user = new UserSession(loggedUser.getId(), loggedUser.getPseudo(), loggedUser.getFullName(), loggedUser.getMail(), rememberMe);*/
            try{
                /**
                 * 
                 *  Using a SessionScoped always return null when calling from a view, don't realy know why :( 
                 */
                //session.setAttribute("user", user);
                session.setAttribute("id", loggedUser.getId());
                session.setAttribute("username", loggedUser.getPseudo());
                session.setAttribute("fullname", loggedUser.getFullName());
                session.setAttribute("mail", loggedUser.getMail());
                session.setAttribute("picture", loggedUser.getPicture());
                session.setAttribute("role", loggedUser.getRole().getName());
                /**
                 * Remember Me will be used through a cookie, not priority right now
                 */
                
            } catch(Exception e) { e.printStackTrace(); }

            HttpServletRequest origRequest = (HttpServletRequest) context.getExternalContext().getRequest();
            String contextPath = origRequest.getContextPath();
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect(contextPath  + "/dashboard");
            } catch (IOException e) { e.printStackTrace(); }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("192.168.128.12:8888/NatAdmin/users/login");
            } catch (IOException e) { e.printStackTrace(); }
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
