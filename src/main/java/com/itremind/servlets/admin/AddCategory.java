package com.itremind.servlets.admin;

import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.CategoryEntityManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@WebServlet("/Administration/Categories/AddCat")
public class AddCategory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "Add new category");
        req.getRequestDispatcher("/admin/addcat.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CategoryEntityManager manager = CategoryEntityManager.getInstance();
        CategoryEntity category = new CategoryEntity(req.getParameter("name"), req.getParameter("desc"));
        manager.create(category);
        req.getRequestDispatcher("/admin/addcat.jsp").forward(req,resp);
    }
}
