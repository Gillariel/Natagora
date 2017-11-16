/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natadmin.servlet;

import com.helmo.al.natadmin.client.BaseClient;
import java.util.List;

/**
 *
 * @author Maude Foerster
 */
class BaseHandler<T> {

    Class<T> entityClass;
    protected BaseClient client;
    
    public BaseHandler(Class<T> entity, BaseClient client) {
        this.entityClass = entity;
        this.client = client;
    }
    
    protected <T> List<T> all() {
        return client.getAll();
    }
    
    protected T find(String id) {
        return (T) client.get(id);
    }
    
}
