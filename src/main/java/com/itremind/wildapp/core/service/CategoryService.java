package com.itremind.wildapp.core.service;

import com.itremind.wildapp.core.model.Category;

import java.util.List;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */
public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryByAlias(String alias);
}
