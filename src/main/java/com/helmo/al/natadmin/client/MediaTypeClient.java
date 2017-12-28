/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.client;

import com.helmo.al.natadmin.entity.MediaTypeDB;
import com.helmo.al.natadmin.security.RequestBuilder;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author foers
 */
public class MediaTypeClient extends BaseClient<MediaTypeDB>{
    
    public MediaTypeClient() {
        super(MediaTypeDB.class, new GenericType<List<MediaTypeDB>>(){}, "mediatype");
    }
    
    @Override
    public List<MediaTypeDB> getAll() {
        return super.getAll();
    }
    
    @Override
    public MediaTypeDB get(String id) {
        return RequestBuilder.execute(getRessource().path("/"+id), MediaTypeDB.class);
    }
}
