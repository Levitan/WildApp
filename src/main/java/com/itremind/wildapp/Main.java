package com.itremind.wildapp;

import com.itremind.wildapp.controllers.NavigationCtrl;
import com.itremind.wildapp.controllers.beans.NavItem;
import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.dao.NavigationDao;
import com.itremind.wildapp.core.dao.PropertyDao;
import com.itremind.wildapp.core.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlevi on 21.05.2017.
 */
@ControllerAdvice
public class Main{
    @Autowired
    NavigationDao navigationDao;
    @Autowired
    PropertyDao propertyDao;
    @Autowired
    ArticleDao articleDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    NavigationCtrl navigationCtrl;

    @ModelAttribute("topnav")
    public List<NavItem> globalNav(){
        return navigationCtrl.getMainNavigation();
    }

}
