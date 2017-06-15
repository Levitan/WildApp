package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.AbstractDao;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */
@Transactional
@Repository
public abstract class AbstractDaoImpl <E, I extends Serializable> implements AbstractDao<E, I> {
    private Class<E> entityClass;

    protected AbstractDaoImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
    @SuppressWarnings("unchecked")
    public E findById(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public void saveOrUpdate(E e) {
        getCurrentSession().saveOrUpdate(e);
    }

    public E save(E e) {
        return (E) getCurrentSession().save(e);
    }

    public void delete(E e) {
        getCurrentSession().delete(e);
    }

    public List findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        criteria.add(criterion);
        return criteria.list();
    }

    public List findAll(){
        DetachedCriteria criteria = DetachedCriteria.forClass(entityClass);
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
