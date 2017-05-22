package com.itremind.servlets.admin;

import com.itremind.entities.CategoryEntity;
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
@WebServlet("/Administration/Categories")
public class CategoryList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Category Management");
        CategoryEntityManager manager = CategoryEntityManager.getInstance();
        List<CategoryEntity> categories = manager.getAllCategories();
        req.setAttribute("cats", categories);
        req.getRequestDispatcher("/admin/catlist.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
