/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.servlet;

import com.helmo.al.natadmin.client.MediaTypeClient;
import com.helmo.al.natadmin.entity.MediaTypeDB;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author foers
 */

@ManagedBean
@RequestScoped
public class MediaTypeHandler {
    public List<MediaTypeDB> all() {
        return new MediaTypeClient().findAll();
    }
    
    public MediaTypeDB find(int id) {
        return new MediaTypeClient().find(id);
    }
}
