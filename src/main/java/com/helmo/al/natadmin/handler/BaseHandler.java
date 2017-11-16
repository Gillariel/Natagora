/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.handler;

import com.helmo.al.natadmin.client.BaseClient;
import java.util.List;

/**
 *
 * @author Maude Foerster
 * @see getAll, get(Id) and count are already defined
 * Custom Request are made by calling super.getCustomXXXX(path)  
 */
class BaseHandler<T> {

    Class<T> entityClass;
    protected BaseClient client;
    
    public BaseHandler(Class<T> entity, BaseClient client) {
        this.entityClass = entity;
        this.client = client;
    }
    
    public <T> List<T> all() {
        return client.getAll();
    }
    
    public T find(String id) {
        return (T) client.get(id);
    }
    
    public String count() {
        return client.count();
    }
}
