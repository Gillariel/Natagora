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
    
    private Class<T> entityClass;
    
    private static EntityManager EM = Persistence.createEntityManagerFactory("NataRest").createEntityManager();

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public static EntityManager getEntityManager(){
        return EM;
    };

    public T saveAndReturn(T entity){
        if(isNull(entity))
            return null;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return entity;
        } catch(Exception e){ 
            ResetEntityManager();
            return null; 
        }  
    }
    
    public boolean save(T entity) {
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ 
            ResetEntityManager();
            return false; 
        }       
    }

    public boolean update(T entity) {
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entity);
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ 
            ResetEntityManager();
            return false; 
        }    
    }

    public boolean delete(T entity) {
        if(isNull(entity))
            return false;
        try{
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(getEntityManager().merge(entity));
            getEntityManager().flush();
            getEntityManager().getTransaction().commit();
            return true;
        } catch(Exception e){ 
            ResetEntityManager();
            return false; 
        }    
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
     *  Because of the loosing of the Generic Type between all method.
     * 
     *  Keep it here in case of a solution has been found to execute everything from a single method
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
    
    public static enum Operation {
        CREATE,
        UPDATE,
        DELETE
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
    
    public void ResetEntityManager() {
        AbstractDao.EM.close();
        AbstractDao.EM = null;
        AbstractDao.EM = Persistence.createEntityManagerFactory("NataRest").createEntityManager();
    }
}
