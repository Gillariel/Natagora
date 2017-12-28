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
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ WebFilter(asyncSupported = true, urlPatterns = { "/*" })
public class LoginFilter implements Filter{

    public LoginFilter() {
    }

    
    @Override
    public void destroy() { }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
            FilterChain chain) throws IOException, ServletException {
        
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        res.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession(false);
        
        if(req.getRequestURL().toString().contains("users/logout")){
            try{
                session.removeAttribute("id");
                session.removeAttribute("username");
                session.removeAttribute("fullname");
                session.removeAttribute("mail");
                session.removeAttribute("picture");
                session.removeAttribute("role");
            } catch(Exception e) { }
        }
        
        Object user = (session != null) ? session.getAttribute("username") : null;
        
        String loginUrl = req.getContextPath() + "/users/login";
        
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
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException { }
}
