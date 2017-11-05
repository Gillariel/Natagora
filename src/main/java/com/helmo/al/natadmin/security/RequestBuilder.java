/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.security;

import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author foers
 */
public class RequestBuilder {

    /**
     *
     * @param t The webTarget object
     * @return The Request with correct headers
     */
    public static Builder Build(WebTarget t){
        return t.request(javax.ws.rs.core.MediaType.APPLICATION_JSON)
                .header("api-key", Global.API_KEY);
    }
}
