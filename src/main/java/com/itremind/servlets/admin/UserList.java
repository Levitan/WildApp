package com.itremind.servlets.admin;

import com.itremind.entities.UsersEntity;
import com.itremind.entitymanagers.UsersEntityManager;

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
@WebServlet("/Administration/UserManagement")
public class UserList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("title", "User Management");

        UsersEntityManager manager = UsersEntityManager.getInstance();
        List<UsersEntity> users = manager.getAllUsers();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/admin/userlist.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
