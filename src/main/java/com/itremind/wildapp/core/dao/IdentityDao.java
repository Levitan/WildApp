package com.itremind.wildapp.core.dao;

import com.itremind.wildapp.core.model.Identity;

import java.util.List;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
public interface IdentityDao extends AbstractDao<Identity, Long> {
    List<Identity> getAllUsers();
    Identity getIdentityByLogin(String login);
}
