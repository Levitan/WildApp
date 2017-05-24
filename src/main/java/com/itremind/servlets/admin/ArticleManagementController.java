package com.itremind.servlets.admin;

import com.itremind.entities.ArticleEntity;
import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.ArticleEntityManager;
import com.itremind.entitymanagers.CategoryEntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class ArticleManagementController {

    @RequestMapping(value = "/Administration/Articles", method = RequestMethod.GET)
    public String articleList(@RequestParam Map<String,String> params, Model model){
        model.addAttribute("title", "Article management");
        ArticleEntityManager manager = ArticleEntityManager.getInstance();
        CategoryEntityManager catManager = CategoryEntityManager.getInstance();
        List<ArticleEntity> articles = manager.getAllArticles();
        List<CategoryEntity> cats = catManager.getAllCategories();

        model.addAttribute("cats", cats);
        model.addAttribute("articles", articles);
        return "/admin/articlelist";
    }
}
