package com.itremind.wildapp.core.service;

import com.itremind.wildapp.core.model.Article;

import java.util.List;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
public interface ArticleService {
    List<Article> getAllArticles();
    Article getArticleByAlias(String alias);
    List<Article> getArticlesByCatId(Long id);
    List<Article> getByPage(int page, int total, Long catId);
    Long getArticlesCount(Long catId);
}
