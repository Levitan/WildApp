package com.itremind.entitymanagers;

import com.itremind.entities.CategoryEntity;
import com.itremind.utils.DBFactory;

import java.util.List;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
public class CategoryEntityManager {
    private static CategoryEntityManager instance = new CategoryEntityManager();
    private CategoryEntityManager(){}
    public static CategoryEntityManager getInstance(){
        return instance;
    }
    public void create(CategoryEntity e){
        DBFactory db = DBFactory.getInstance();
        db.create(e);
    }
    public void update(CategoryEntity e){
        DBFactory db = DBFactory.getInstance();
        db.update(e);
    }
    public void delete(CategoryEntity e){
        DBFactory db = DBFactory.getInstance();
        db.delete(e);
    }
    public List<CategoryEntity> getAllCategories(){
        DBFactory db = DBFactory.getInstance();
        List<CategoryEntity> result = db.getAllObjects(CategoryEntity.class);
        return result;
    }
}
