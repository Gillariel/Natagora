/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.security;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */
@ManagedBean
@RequestScoped
public class GlobalAjax {
    public String apiKey(){
        return Global.API_KEY;
    }
}
