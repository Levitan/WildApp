package com.itremind.wildapp.core.dao;

import com.itremind.wildapp.core.model.Property;

import java.util.List;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
public interface PropertyDao extends AbstractDao<Property, Long>{
    Property getProperty(String property);
    void saveProperty(Property property);
    List<Property> getAllProperties();
}
