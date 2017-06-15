package com.itremind.wildapp.core.dao;

import com.itremind.wildapp.core.model.Menu;

import java.util.List;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
public interface MenuDao extends AbstractDao<Menu, Long> {
    List<Menu> getAllMenu();
    List<Menu> getMenyByType(Integer type);
}
