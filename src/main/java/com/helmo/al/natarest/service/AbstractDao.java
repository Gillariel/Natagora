/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.filter.AuthFilter;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author foers
 */
@SuppressWarnings("unchecked")
public abstract class AbstractDao<T> extends AuthFilter{

    public static enum Operation {
        CREATE,
        UPDATE,
        DELETE
    }
    
    private Class<T> entityClass;
    
    private static final EntityManager EM = Persistence.createEntityManagerFactory("NataRest").createEntityManager();

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public static EntityManager getEntityManager(){
        return EM;
    };

    public boolean save(T entity) {
        //return this.exec(Operation.CREATE, entity);
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ return false; }       
    }

    public boolean update(T entity) {
        //return this.exec(Operation.UPDATE, entity);
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ return false; }    
    }

    public boolean delete(T entity) {
        //return this.exec(Operation.DELETE, entity);
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ return false; }    
    }

    public T get(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> getAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> getRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    /**
     *  Working only for delete, Create and Update doesn't work that way
     *  (Don't know why)
     */
    /*
    private boolean exec(Operation type, T entity){
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            switch(type){
                case CREATE : {
                    getEntityManager().persist(entity);
                }
                case UPDATE : {
                    getEntityManager().merge(entity);
                }
                case DELETE : {
                    getEntityManager().remove(getEntityManager().merge(entity));
                }
            }
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){
            return false;
        }
    }
    */
    
    private boolean isNull(T entity){
        return (entity == null);
    }
            
    public static boolean validApplication(String apikey) {                                              
        List<com.helmo.al.natarest.entity.Application> results = 
            EM.createQuery("SELECT a FROM Application a WHERE a.apiKey = :KEY")
                    .setParameter("KEY", apikey)
                    .getResultList();

        return (results.size() == 1);
    }
    
    
}
