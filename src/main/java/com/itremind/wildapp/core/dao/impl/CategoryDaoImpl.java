package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.model.Category;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Borisovskiy.V on 09.06.2017.
 */

@Component
@Transactional
public class CategoryDaoImpl extends AbstractDaoImpl<Category, Long> implements CategoryDao{

    public CategoryDaoImpl() {
        super(Category.class);
    }


    public CategoryDaoImpl(Class<Category> entityClass) {
        super(entityClass);
    }

    public List<Category> getAllCategories() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
        criteria.addOrder(Order.asc("id"));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public Category getCategoryByAlias(String alias){
        DetachedCriteria criteria = DetachedCriteria.forClass(Category.class);
        criteria.add(Restrictions.eq("alias", alias));
        return (Category) criteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
    }
}
