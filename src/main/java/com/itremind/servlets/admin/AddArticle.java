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

@WebServlet("/Administration/Articles/AddArticle")
public class AddArticle extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add new article");
        CategoryEntityManager catManager = CategoryEntityManager.getInstance();
        List<CategoryEntity> catList = catManager.getAllCategories();
        req.setAttribute("cats", catList);
        req.getRequestDispatcher("/admin/addarticle.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArticleEntity article = new ArticleEntity(req.getParameter("name"),
                req.getParameter("content"), Integer.valueOf(req.getParameter("cat")));
        ArticleEntityManager manager = ArticleEntityManager.getInstance();
        manager.create(article);
        req.getRequestDispatcher("/admin/addarticle.jsp").forward(req,resp);
    }
}
