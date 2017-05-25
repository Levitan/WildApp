package com.itremind.entitymanagers;

import com.itremind.entities.ArticleEntity;
import com.itremind.utils.DBFactory;

import java.util.List;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
public class ArticleEntityManager {
    private static ArticleEntityManager instance = new ArticleEntityManager();
    private ArticleEntityManager(){}
    public static ArticleEntityManager getInstance(){
        return instance;
    }
    public void create(ArticleEntity e){
        DBFactory db = DBFactory.getInstance();
        db.create(e);
    }
    public void update(ArticleEntity e){
        DBFactory db = DBFactory.getInstance();
        db.update(e);
    }
    public void delete(ArticleEntity e){
        DBFactory db = DBFactory.getInstance();
        db.delete(e);
    }
    public List<ArticleEntity> getAllArticles(){
        DBFactory db = DBFactory.getInstance();
        List<ArticleEntity> result = db.getAllObjects(ArticleEntity.class);
        return result;
    }
    public List<ArticleEntity> getArticlesByCatId(int id){
        DBFactory db = DBFactory.getInstance();
        List<ArticleEntity> result = db.createQuery("select ARTICLE from com.itremind.entities.ArticleEntity ARTICLE where ARTICLE.cat_id = :id")
                .setParameter("id", id).list();
        return result;
    }
    public ArticleEntity getArticleById(Integer id){
        DBFactory db = DBFactory.getInstance();
        return (ArticleEntity) db.getById(ArticleEntity.class, id);
    }
}
