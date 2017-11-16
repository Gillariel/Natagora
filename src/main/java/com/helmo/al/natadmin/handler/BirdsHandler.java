/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.BirdsClient;
import com.helmo.al.natadmin.entity.Bird;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class BirdsHandler {
    public List<Bird> all() {
        return new BirdsClient().findAll();
    }
    
    public Bird get(int id) {
        return new BirdsClient().find(id);
    }
    
    public String count() {
        return new BirdsClient().count();
    }
}
