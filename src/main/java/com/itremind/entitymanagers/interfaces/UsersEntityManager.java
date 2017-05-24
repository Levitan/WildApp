package com.itremind.entitymanagers.interfaces;

import com.itremind.entities.UsersEntity;

import java.util.List;

/**
 * Created by Borisovskiy.V on 24.05.2017.
 */
public interface UsersEntityManager {
    void create(UsersEntity e);
    void update(UsersEntity e);
    void delete(UsersEntity e);
    List<UsersEntity> getAllUsers();
    List<UsersEntity> getUserByLogin(String login);
    UsersEntity getUserById(Integer id);
}
