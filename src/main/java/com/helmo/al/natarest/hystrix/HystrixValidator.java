/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import java.util.List;

/**
 *
 * @author foers
 */
public class HystrixValidator<T> extends HystrixCommand<Boolean> {
    private final T entity;
    private final List<T> entities;
    
    public HystrixValidator(T entity) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory
            .asKey("entity")));
        this.entity = entity; 
        this.entities = null;
    }

    public HystrixValidator(List<T> entities) {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory
            .asKey("entity")));
            this.entities = entities; 
            this.entity = null;
    }
    
    @Override
    protected Boolean run() throws Exception {
        if(entity != null)
            return new Validator().isValid(entity);
        else{
            for(T t : entities)
                if(!new Validator().isValid(t))
                    return false;
            return true;
        }
    }
}
