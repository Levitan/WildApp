package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.AbstractDao;
import com.itremind.wildapp.core.dao.NavigationDao;
import com.itremind.wildapp.core.model.Navigation;
import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

/**
 * Created by Borisovskiy.V on 20.06.2017.
 */
@Component
public class NavigationDaoImpl extends AbstractDaoImpl<Navigation, Long> implements NavigationDao {
    protected NavigationDaoImpl(Class<Navigation> entityClass) {
        super(entityClass);
    }

    protected NavigationDaoImpl() {
        super(Navigation.class);
    }

    public List<Navigation> getNavByType(int type) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Navigation.class);
        criteria.add(Restrictions.eq("type", type));
        criteria.addOrder(Order.asc("nOrder"));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public List<Navigation> getNavByActive(Boolean active) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Navigation.class);
        criteria.add(Restrictions.eq("enable", active));
        criteria.addOrder(Order.asc("nOrder"));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public Navigation getByContentId(Long id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Navigation.class);
        criteria.add(Restrictions.eq("contentId", id));
        criteria.addOrder(Order.asc("nOrder"));
        return (Navigation) criteria.getExecutableCriteria(getCurrentSession());
    }

    public List<Navigation> getAllNav() {
        return findAll();
    }

    public String getItemURI(Navigation nav) {
        String result = "#";
        if (nav.getType() == Navigation.ARTICLE) {
            result = (String) getCurrentSession().createQuery("select concat('/', cat.alias, '/', art.alias) from Category as cat, Article as art where art.id = :articleId and cat.id=art.catId")
                    .setParameter("articleId", nav.getContentId())
                    .uniqueResult();
        } else if (nav.getType() == Navigation.CATEGORY) {
            result = (String) getCurrentSession().createQuery("select concat('/', cat.alias) from Category cat where cat.id=:catId")
                    .setParameter("catId", nav.getContentId())
                    .uniqueResult();
        }
        return result;
    }
}
