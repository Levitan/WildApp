package com.itremind.servlets.admin;

import com.itremind.entities.ArticleEntity;
import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.ArticleEntityManager;
import com.itremind.entitymanagers.CategoryEntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@WebServlet("/Administration/Articles")
public class ArticleList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Article management");
        ArticleEntityManager manager = ArticleEntityManager.getInstance();
        CategoryEntityManager catManager = CategoryEntityManager.getInstance();
        List<ArticleEntity> articles = manager.getAllArticles();
        List<CategoryEntity> cats = catManager.getAllCategories();
        req.setAttribute("cats", cats);
        req.setAttribute("articles", articles);
        req.getRequestDispatcher("/admin/articlelist.jsp").forward(req, resp);
    }
}
