package com.itremind.wildapp.core.dao;

import com.itremind.wildapp.core.model.Navigation;

import java.util.List;

/**
 * Created by Borisovskiy.V on 20.06.2017.
 */
public interface NavigationDao extends AbstractDao<Navigation, Long> {
    List<Navigation> getNavByType(int type);
    List<Navigation> getNavByActive(Boolean active);
    Navigation getByContentId(Long id);
    List<Navigation> getAllNav();
    String getItemURI(Navigation nav);
}
