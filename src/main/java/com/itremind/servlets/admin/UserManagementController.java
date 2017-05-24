package com.itremind.servlets.admin;

import com.itremind.entities.UsersEntity;
import com.itremind.entitymanagers.UsersEntityManagerImpl;
import com.itremind.entitymanagers.interfaces.UsersEntityManager;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */

@Controller
public class UserManagementController {
    private UsersEntityManager manager = UsersEntityManagerImpl.getInstance();

    @RequestMapping(value = "/Administration/UserManagement", method = RequestMethod.GET)
    public String userList(@RequestParam Map<String,String> params, Model model){
        if(params.get("delete") != null){
            manager.delete(manager.getUserById(Integer.valueOf(params.get("delete"))));
            return "redirect:/Administration/UserManagement";
        }
        model.addAttribute("title", "User Management");
        List<UsersEntity> users = manager.getAllUsers();
        model.addAttribute("users", users);
        return "/admin/userlist";
    }

    @RequestMapping(value = "/Administration/UserManagement/Manage", method = RequestMethod.GET)
    public String userAddView(@RequestParam Map<String,String> params, Model model){
        if(params.get("mode").equals("add")){
            model.addAttribute("title", "Add user");
            model.addAttribute("method", "POST");
            return "/admin/adduser";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute("title", "Edit user");
            model.addAttribute("method", "PUT");
            model.addAttribute("lock", "disable");
            UsersEntity user = manager.getUserById(Integer.valueOf(params.get("id")));
            model.addAttribute("user", user);
            return "/admin/adduser";
        } else {
            return "redirect:/Administration/UserManagement";
        }
    }
    @RequestMapping(value = "/Administration/UserManagement/AddUser", method = RequestMethod.POST)
    public String userAdd(@RequestParam Map<String,String> params){

        UsersEntity newUser = new UsersEntity(params.get("login"),
                params.get("pass"),
                params.get("fname"),
                params.get("lname"),
                Integer.valueOf(params.get("age")));
        manager.create(newUser);
        return "redirect:/Administration/UserManagement";
    }
    @RequestMapping(value = "/Administration/UserManagement/Update", method = RequestMethod.PUT)
    public String updateUser(@RequestParam Map<String,String> params){
        UsersEntity user = manager.getUserById(Integer.valueOf(params.get("id")));
        user.setPassword(params.get("pass"));
        user.setFirstName(params.get("fname"));
        user.setSecondName(params.get("lname"));
        user.setAge(Integer.valueOf(params.get("age")));
        manager.update(user);
        return "redirect:/Administration/UserManagement";
    }
}