/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

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
public class MediaTypeHandler extends BaseHandler<MediaTypeDB> {

    public MediaTypeHandler() {
        super(MediaTypeDB.class, new MediaTypeClient());
    }
}
