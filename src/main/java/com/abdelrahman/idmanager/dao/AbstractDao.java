/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abdelrahman.idmanager.dao;

import com.abdelrahman.idmanager.utility.HibernateUtil;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author NIGHT WOLF
 * @param <PK>
 * @param <T>
 */

public abstract class AbstractDao<PK extends Serializable, T>
{

    private final Class<T> persistentClass;
    private final SessionFactory sessionFactory;
    @SuppressWarnings("unchecked")
    public AbstractDao()
    {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        this.sessionFactory=HibernateUtil.getSessionFactory();
    }
    
    

    protected Session getSession()
    {
        return sessionFactory.getCurrentSession();
    }
    
    public List<T> getAll()
    {
        Transaction trans=getSession().beginTransaction();
        Criteria crit = createEntityCriteria();
        List<T> entities=crit.list();
        trans.commit();
        return entities;
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key)
    {
        Transaction trans=getSession().beginTransaction();
        T t=(T) getSession().get(persistentClass, key);
        trans.commit();
        return t;
    }

    public T persist(T entity)
    {
        Transaction trans=getSession().beginTransaction();
        getSession().persist(entity);
        trans.commit();
        return entity;
    }

    public T update(T entity)
    {
        Transaction trans=getSession().beginTransaction();
        getSession().update(entity);
        trans.commit();
        return entity;
    }

    public void delete(T entity)
    {
        Transaction trans=getSession().beginTransaction();
        getSession().delete(entity);
        trans.commit();
    }

    protected Criteria createEntityCriteria()
    {
        return getSession().createCriteria(persistentClass);
    }
}
