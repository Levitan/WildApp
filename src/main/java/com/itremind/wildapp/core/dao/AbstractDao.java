package com.itremind.wildapp.core.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */
public interface AbstractDao <E, I extends Serializable> {
    public Session getCurrentSession();
    public E findById(I id);
    public void saveOrUpdate(E e);
    public void delete(E e);
    public E save(E e);
    public List findByCriteria(Criterion criterion);
    public List findAll();
}
