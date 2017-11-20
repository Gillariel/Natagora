package com.helmo.al.natadmin.filter;

import com.helmo.al.natadmin.handler.UserSession;
import java.io.IOException;
import java.util.Map;
import javax.faces.application.ResourceHandler;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession(false);
        
        UserSession user = (session != null) ? (UserSession)session.getAttribute("user") : null;
        
        String loginUrl = req.getContextPath() + "/users/login.xhtml";
        
        boolean loginRequest = req.getRequestURL().toString().contains("users/login");
        boolean resourceRequest = req.getServletPath().startsWith(ResourceHandler.RESOURCE_IDENTIFIER);
        
        if(user != null || loginRequest || resourceRequest){
            if(!resourceRequest) {
                res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
                res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
                res.setDateHeader("Expires", 0); // Proxies.
            }
            chain.doFilter(req, res); 
        } else {
            res.sendRedirect(loginUrl);
        }  
        //chain.doFilter(req,res);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException { }
}
