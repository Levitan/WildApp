package com.itremind.wildapp.servlets.site;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.model.Article;
import com.itremind.wildapp.core.model.Category;
import com.itremind.wildapp.core.utils.ContentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Borisovskiy.V on 04.06.2017.
 */
@Controller
public class IndexController {

//    private CategoryEntityManager catManager = CategoryEntityManager.getInstance();
//    private ArticleEntityManager articleManager = ArticleEntityManager.getInstance();
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private ArticleDao articleDao;



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexView(Model model) {

        Category cat = categoryDao.getCategoryByAlias("articles");
        List<Article> articles = articleDao.getByPage(1, ContentUtils.perPage, cat.getId());
        List<Article> allArticles = articleDao.getArticlesByCatId(cat.getId());
        int pageCount = ContentUtils.getPageCount(articleDao.getArticlesCount(cat.getId()).intValue());
        model.addAttribute("title", cat.getName());
        model.addAttribute("category", cat);
        model.addAttribute("articles", articles);
        model.addAttribute("allArticles", allArticles);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("currentPage", 1);
        return "/site/category";
    }

    @RequestMapping(value = "/page_{page}", method = RequestMethod.GET)
    public String indexView(@PathVariable int page, Model model){
        Category cat = categoryDao.getCategoryByAlias("articles");
        List<Article> articles = articleDao.getByPage(page, ContentUtils.perPage, cat.getId());
        int pageCount = ContentUtils.getPageCount(articleDao.getArticlesCount(cat.getId()).intValue());

        model.addAttribute("title", cat.getName());
        model.addAttribute("category", cat);
        model.addAttribute("articles", articles);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("currentPage", page);
        model.addAttribute("isCat", Boolean.TRUE);

        return "/site/category";
    }



    @RequestMapping(value = "/{category}/{article}")
    public String articleView(@PathVariable String category,
                              @PathVariable String article,
                              Model model) {
        Category cat = categoryDao.getCategoryByAlias(category);
        Article art = articleDao.getArticleByAlias(article);

        model.addAttribute("title", art.getName());
        model.addAttribute("cat", cat);
        model.addAttribute("art", art);

        return "/site/article";
    }


}
