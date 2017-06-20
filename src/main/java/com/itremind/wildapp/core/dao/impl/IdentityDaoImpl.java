package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.IdentityDao;
import com.itremind.wildapp.core.model.Identity;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
@Component
@Transactional
public class IdentityDaoImpl extends AbstractDaoImpl<Identity, Long> implements IdentityDao {
    protected IdentityDaoImpl(Class<Identity> entityClass) {
        super(entityClass);
    }

    protected IdentityDaoImpl(){
        super(Identity.class);

    }

    public List<Identity> getAllUsers() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Identity.class);
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public Identity getIdentityByLogin(String login) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Identity.class);
        criteria.add(Restrictions.eq("login", login));
        return (Identity) criteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
    }
}
