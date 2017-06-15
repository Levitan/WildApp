package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.MenuDao;
import com.itremind.wildapp.core.model.Menu;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Component
@Transactional
public class MenuDaoImpl extends AbstractDaoImpl<Menu, Long> implements MenuDao {


    protected MenuDaoImpl(Class<Menu> entityClass) {
        super(entityClass);
    }

    protected MenuDaoImpl(){
        super(Menu.class);
    }

    public List<Menu> getAllMenu() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
        criteria.addOrder(Order.asc("type"));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public List<Menu> getMenyByType(Integer type) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Menu.class);
        criteria.add(Restrictions.eq("type", type));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }
}
