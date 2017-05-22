package com.itremind.servlets.site;

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
 * Created by vlevi on 21.05.2017.
 */
@WebServlet("/new")
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("myname", "Vitaly Levitan");
        Map params = req.getParameterMap();
        req.getRequestDispatcher("/site/page.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
