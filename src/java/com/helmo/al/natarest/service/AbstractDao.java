/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helmo.al.natarest.service;

import com.helmo.al.natarest.filter.AuthFilter;
import java.util.ArrayList;
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
    
    private static final EntityManager EM = Persistence.createEntityManagerFactory("NataRestPU2").createEntityManager();

    public AbstractDao(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public static EntityManager getEntityManager(){
        return EM;
    };

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int[] range) {
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

    @Override
    protected void finalize() throws Throwable {
        this.EM.close();
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static boolean validApplication(String apikey) {                                              
        List<com.helmo.al.natarest.entity.Application> results = 
            EM.createQuery("SELECT a FROM Application a WHERE a.apiKey = :KEY")
                    .setParameter("KEY", apikey)
                    .getResultList();

        return (results.size() == 1);
    }
}
