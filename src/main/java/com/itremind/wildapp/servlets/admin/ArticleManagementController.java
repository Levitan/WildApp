package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.model.Article;
import com.itremind.wildapp.core.model.Category;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class ArticleManagementController implements ManagementController{


    @Autowired
    private ArticleDao articleDao;
    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "/Administration/Articles", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute(PAGE_TITLE, "Article management");

        List<Article> articles = articleDao.getAllArticles();
        List<Category> cats = categoryDao.getAllCategories();

        model.addAttribute("cats", cats);
        model.addAttribute("articles", articles);
        return "/admin/articlelist";
    }

    @RequestMapping(value = "Administration/Articles/Delete/{articleId}")
    public String deleteObject(@PathVariable Long articleId){
        articleDao.delete(articleDao.findById(articleId));
        return "redirect:/Administration/Articles";
    }

    @RequestMapping(value = "/Administration/Articles/Manage", method = RequestMethod.GET)
    public String addView(@RequestParam Map<String, String> params, Model model) {
        List<Category> cats = categoryDao.getAllCategories();

        if(params.get("mode").equals("add")){
            model.addAttribute(PAGE_TITLE, "Add article");
            model.addAttribute("uri", "Add");
            model.addAttribute("cats", cats);
            return "/admin/addarticle";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute(PAGE_TITLE, "Edit article");
            model.addAttribute("uri", "Update");
            model.addAttribute("lock", "disabled");
            Article article = articleDao.findById(Long.valueOf(params.get("id")));
            model.addAttribute("article", article);
            model.addAttribute("cats", cats);
            return "/admin/addarticle";
        } else {
            return "redirect:/Administration/Articles";
        }
    }
    @RequestMapping(value = "/Administration/Articles/Add", method = RequestMethod.POST)
    public String objectAdd(@RequestParam Map<String, String> params) {
        Article article = new Article(
                Long.valueOf(params.get("cat")),
                params.get("content"),
                params.get("name"),
                new Timestamp(new Date().getTime()),
                params.get("alias"));
        articleDao.save(article);
        return "redirect:/Administration/Articles";
    }
    @RequestMapping(value = "/Administration/Articles/Update", method = RequestMethod.POST)
    public String objectUpdate(@RequestParam Map<String, String> params) {
        Article article = articleDao.findById(Long.valueOf(params.get("id")));
        article.setCatId(Long.valueOf(params.get("cat")));
        article.setName(params.get("name"));
        article.setContent(params.get("content"));
        article.setDate(new Timestamp(new Date().getTime()));
        articleDao.saveOrUpdate(article);
        return "redirect:/Administration/Articles";
    }

    @RequestMapping(value = "/Administration/Articles/View/{articleId}", method = RequestMethod.GET)
    public String viewObject(@PathVariable Long articleId, Model model){
        Article article = articleDao.findById(articleId);
        model.addAttribute("article", article);
        return "/admin/view";
    }
}
