/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.filter;

import com.helmo.al.natadmin.handler.UserSession;
import java.io.IOException;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.omnifaces.filter.HttpFilter;
import org.omnifaces.util.Servlets;

/**
 *
 * @author foers
 */
@WebFilter("/*")
public class LoginFilter extends HttpFilter  {

    @Inject
    private Instance<UserSession> instance;

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, HttpSession session, FilterChain chain) throws ServletException, IOException {
        String loginURL = request.getContextPath() + "/NatAdmin/users/login.xhtml";

        boolean loggedIn = (instance != null) && (instance.get() != null) && (instance.get().getUsername() != null) && (!instance.get().getUsername().equals(""));
        boolean loginRequest = request.getRequestURI().equals(loginURL);
        boolean resourceRequest = Servlets.isFacesResourceRequest(request);

        if (loggedIn || loginRequest || resourceRequest) {
            if (!resourceRequest) {
                response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
            }
            chain.doFilter(request, response);
        }
        else {
            Servlets.facesRedirect(request, response, loginURL);
        }
    }
}
