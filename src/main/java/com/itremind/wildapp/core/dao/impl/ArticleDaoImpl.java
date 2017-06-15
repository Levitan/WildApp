package com.itremind.wildapp.core.dao.impl;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.model.Article;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
@Component
@Transactional
public class ArticleDaoImpl extends AbstractDaoImpl<Article, Long> implements ArticleDao {
    protected ArticleDaoImpl(Class<Article> entityClass) {
        super(entityClass);
    }
    protected ArticleDaoImpl(){
        super(Article.class);
    }

    public List<Article> getAllArticles() {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public Article getArticleByAlias(String alias) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.add(Restrictions.eq("alias", alias));
        return (Article) criteria.getExecutableCriteria(getCurrentSession()).list().get(0);
    }

    public List<Article> getArticlesByCatId(Long id) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.add(Restrictions.eq("catId", id));
        return criteria.getExecutableCriteria(getCurrentSession()).list();
    }

    public List<Article> getByPage(int page, int total, Long catId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.add(Restrictions.eq("catId", catId));
        int firstResult = (page-1) * total;
//        criteria.add(Restrictions.sqlRestriction("LIMIT " + String.valueOf(firstResult) + ", " + String.valueOf(maxResult)));
        return criteria.getExecutableCriteria(getCurrentSession())
                .setFirstResult(firstResult)
                .setMaxResults(total).list();
    }

    public Long getArticlesCount(Long catId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        criteria.setProjection(Projections.rowCount());
        criteria.add(Restrictions.eq("catId", catId));
        return (Long) criteria.getExecutableCriteria(getCurrentSession()).uniqueResult();
    }
}
