package com.itremind.entitymanagers;


import com.itremind.entities.UsersEntity;
import com.itremind.utils.DBFactory;

import java.util.List;

/**
 * Created by vlevi on 22.05.2017.
 */
public class UsersEntityManager{
    private static UsersEntityManager instance = new UsersEntityManager();
    private UsersEntityManager(){}
    public static UsersEntityManager getInstance(){
        return instance;
    }


    public void create(UsersEntity e){
        DBFactory db = DBFactory.getInstance();
        db.create(e);
    }
    public void update(UsersEntity e){
        DBFactory db = DBFactory.getInstance();
        db.update(e);
    }
    public void delete(UsersEntity e){
        DBFactory db = DBFactory.getInstance();
        db.delete(e);
    }
    public List<UsersEntity> getAllUsers(){
        DBFactory db = DBFactory.getInstance();
        List<UsersEntity> result = db.getAllObjects(UsersEntity.class);
        return result;
    }
    public List<UsersEntity> getUserByLogin(String login){
        DBFactory db = DBFactory.getInstance();
        List result = db.createQuery("select USERS from com.itremind.entities.UsersEntity USERS where USERS.login=:login")
                .setParameter("login", login).list();
        return result;
    }
}
