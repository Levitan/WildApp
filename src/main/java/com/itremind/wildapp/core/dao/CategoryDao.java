package com.itremind.wildapp.core.dao;

import com.itremind.wildapp.core.model.Category;

import java.util.List;

/**
 * Created by Borisovskiy.V on 09.06.2017.
 */
public interface CategoryDao extends AbstractDao<Category, Long> {
    public List<Category> getAllCategories();
    Category getCategoryByAlias(String alias);
}
