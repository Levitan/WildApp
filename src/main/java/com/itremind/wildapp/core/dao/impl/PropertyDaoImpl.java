package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.PropertyDao;
import com.itremind.wildapp.core.model.Property;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Component
public class PropertyDaoImpl extends AbstractDaoImpl<Property, Long> implements PropertyDao {
    protected PropertyDaoImpl(Class<Property> entityClass) {
        super(entityClass);
    }

    protected PropertyDaoImpl(){
        super(Property.class);
    }

    public Property getProperty(String property) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Property.class);
        criteria.add(Restrictions.eq("property", property));
        return (Property) criteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
    }

    @Override
    public Property save(Property property) {
        saveProperty(property);
        return property;
    }

    public void saveProperty(Property property) {
        saveOrUpdate(property);
    }

    public List<Property> getAllProperties() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Property.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

}
