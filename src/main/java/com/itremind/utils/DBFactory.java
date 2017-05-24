package com.itremind.utils;

import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by vlevi on 21.05.2017.
 */
public class DBFactory {

    private static DBFactory instance = new DBFactory();
    private DBFactory(){}
    public static DBFactory getInstance(){
        return instance;
    }

    public void create(Object o) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
    }

    public void update(Object o) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object o) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
    }
    public List getAllObjects(Class c){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        List result = session.createCriteria(c).list();
        session.close();
        return result;
    }
    public Query createQuery(String hql){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.createQuery(hql);
    }
    public Object getById(Class c, Integer id){
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        return session.get(c, id);
    }
}
