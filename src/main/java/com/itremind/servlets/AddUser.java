package com.itremind.servlets;

import com.itremind.entities.UsersEntity;
import com.itremind.entities.UsersEntityManager;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by vlevi on 21.05.2017.
 */
@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("adduser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UsersEntity usersEntity = new UsersEntity(req.getParameter("login"),
                DigestUtils.md5Hex(req.getParameter("pass")),
                req.getParameter("fname"),
                req.getParameter("lname"),
                Integer.valueOf(req.getParameter("age")));

        UsersEntityManager manager = UsersEntityManager.getInstance();
        List<UsersEntity> ue = manager.getUserByLogin(req.getParameter("login"));

        if (manager.getUserByLogin(usersEntity.getLogin()).size() == 0) {
            manager.create(usersEntity);
            req.getRequestDispatcher("adduser.jsp").forward(req, resp);
        } else {
            req.setAttribute("error", "User already exists");
            req.getRequestDispatcher("adduser.jsp").forward(req, resp);
        }
    }
}
