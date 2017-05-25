package com.itremind.servlets.admin;

import com.itremind.entities.ArticleEntity;
import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.ArticleEntityManager;
import com.itremind.entitymanagers.CategoryEntityManager;
import com.itremind.servlets.admin.interfaces.ManagementController;
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
public class ArticleManagementController implements ManagementController{

    ArticleEntityManager manager = ArticleEntityManager.getInstance();
    CategoryEntityManager catManager = CategoryEntityManager.getInstance();


    @RequestMapping(value = "/Administration/Articles", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("title", "Article management");
        if(params.get("delete") != null){
            manager.delete(manager.getArticleById(Integer.valueOf(params.get("delete"))));
            return "redirect:/Administration/Articles";
        }

        List<ArticleEntity> articles = manager.getAllArticles();
        List<CategoryEntity> cats = catManager.getAllCategories();

        model.addAttribute("cats", cats);
        model.addAttribute("articles", articles);
        return "/admin/articlelist";
    }

    @RequestMapping(value = "/Administration/Articles/Manage", method = RequestMethod.GET)
    public String addView(@RequestParam Map<String, String> params, Model model) {
        List<CategoryEntity> cats = catManager.getAllCategories();

        if(params.get("mode").equals("add")){
            model.addAttribute("title", "Add article");
            model.addAttribute("uri", "Add");
            model.addAttribute("cats", cats);
            return "/admin/addarticle";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute("title", "Edit article");
            model.addAttribute("uri", "Update");
            model.addAttribute("lock", "disabled");
            ArticleEntity article = manager.getArticleById(Integer.valueOf(params.get("id")));
            model.addAttribute("article", article);
            model.addAttribute("cats", cats);
            return "/admin/addarticle";
        } else {
            return "redirect:/Administration/Articles";
        }
    }
    @RequestMapping(value = "/Administration/Articles/Add", method = RequestMethod.POST)
    public String objectAdd(@RequestParam Map<String, String> params) {
        ArticleEntity article = new ArticleEntity(params.get("name"),
                params.get("content"),
                Integer.valueOf(params.get("cat")));
        manager.create(article);
        return "redirect:/Administration/Articles";
    }
    @RequestMapping(value = "/Administration/Articles/Update", method = RequestMethod.POST)
    public String objectUpdate(@RequestParam Map<String, String> params) {
        ArticleEntity article = manager.getArticleById(Integer.valueOf(params.get("id")));
        article.setCatId(Integer.valueOf(params.get("cat")));
        article.setName(params.get("name"));
        article.setContent(params.get("content"));
        manager.update(article);
        return "redirect:/Administration/Articles";
    }

    @RequestMapping(value = "/Administration/Articles/View", method = RequestMethod.GET)
    public String viewObject(@RequestParam Map<String, String> params, Model model){
        ArticleEntity article = manager.getArticleById(Integer.valueOf(params.get("id")));
        model.addAttribute("article", article);
        return "/admin/view";
    }
}
