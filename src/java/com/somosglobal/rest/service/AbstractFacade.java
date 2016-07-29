/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.somosglobal.rest.service;

import java.util.List;
import javax.persistence.EntityManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
/**
 *
 * @author Paflo
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

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
        try{
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        }
        catch(Exception ex){
                System.out.println(ex);
                }
        return null;
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
    
    public String objToJson(Object ob){
//        
//        List<Task> list = new ArrayList<Task>();
//        for (int i = 0; i < 20; i++) {
//            list.add(new Task(i, "Test1", "Test2", Task.Status.ASSIGNED, 10));
//        }
        
        Gson gson = new Gson();
//        Type type = new TypeToken<List<Object>>() {}.getType();
        Type type = new TypeToken<Object>() {}.getType();
        String json = gson.toJson(ob, type);
        System.out.println(json);
//        List<Object> fromJson = gson.fromJson(json, type);

//        for (Object task : fromJson) {
//                System.out.println(task);
//        }
        return json;
    }
    
}
