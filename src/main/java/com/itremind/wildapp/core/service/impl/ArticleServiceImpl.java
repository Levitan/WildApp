package com.itremind.wildapp.core.service.impl;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.model.Article;
import com.itremind.wildapp.core.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    public Article getArticleByAlias(String alias) {
        return articleDao.getArticleByAlias(alias);
    }

    public List<Article> getArticlesByCatId(Long id) {
        return articleDao.getArticlesByCatId(id);
    }

    public List<Article> getByPage(int page, int total, Long catId) {
        return articleDao.getByPage(page, total, catId);
    }

    public Long getArticlesCount(Long catId) {
        return articleDao.getArticlesCount(catId);
    }
}
