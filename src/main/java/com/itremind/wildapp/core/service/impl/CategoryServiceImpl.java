package com.itremind.wildapp.core.service.impl;

import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.model.Category;
import com.itremind.wildapp.core.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryDao categoryDao;

    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

    public Category getCategoryByAlias(String alias) {
        return categoryDao.getCategoryByAlias(alias);
    }
}
