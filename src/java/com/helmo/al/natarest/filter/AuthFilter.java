package com.helmo.al.natarest.filter;

import com.helmo.al.natarest.service.AbstractDao;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.ext.Provider;

@Provider
@PreMatching
public class AuthFilter implements ContainerRequestFilter {
    
    public void filter(ContainerRequestContext ctx) throws IOException {
        String authHeader = ctx.getHeaderString("api-key");
        if (authHeader == null)
            throw new NotAuthorizedException("Api Key not present.");
        else {
            if(!AbstractDao.validApplication(authHeader))
                throw new NotAuthorizedException("Api Key not correct.");
        }
    }
}