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
    
    private static final BirdsClient CLIENT = new BirdsClient();
    
    public List<Bird> all() {
        return CLIENT.findAll();
    }
    
    public Bird get(int id) {
        return CLIENT.find(id);
    }
    
    public String count() {
        return CLIENT.count();
    }
    
    public String top5(){
        return CLIENT.top5();
    }
    
    public String history() {
        return CLIENT.history();
    }
}
