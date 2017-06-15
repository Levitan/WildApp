package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.IdentityDao;
import com.itremind.wildapp.core.model.Identity;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */

@Controller
public class UserManagementController implements ManagementController{
    
    @Autowired
    IdentityDao identityDao;

    @RequestMapping(value = "/Administration/UserManagement", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String,String> params, Model model){
        if(params.get("delete") != null){
            identityDao.delete(identityDao.findById(Long.valueOf(params.get("delete"))));
            return "redirect:/Administration/UserManagement";
        }
        model.addAttribute(PAGE_TITLE, "User Management");
        List<Identity> users = identityDao.getAllUsers();
        model.addAttribute("users", users);
        return "/admin/userlist";
    }

    @RequestMapping(value = "/Administration/UserManagement/Manage", method = RequestMethod.GET)
    public String addView(@RequestParam Map<String,String> params, Model model){
        if(params.get("mode").equals("add")){
            model.addAttribute(PAGE_TITLE, "Add user");
            model.addAttribute("method", "POST");
            return "/admin/adduser";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute(PAGE_TITLE, "Edit user");
            model.addAttribute("method", "PUT");
            model.addAttribute("lock", "disabled");
            Identity user = identityDao.findById(Long.valueOf(params.get("id")));
            model.addAttribute("user", user);
            return "/admin/adduser";
        } else {
            return "redirect:/Administration/UserManagement";
        }
    }

    @RequestMapping(value = "/Administration/UserManagement/POST", method = RequestMethod.POST)
    public String objectAdd(@RequestParam Map<String,String> params){

        Identity newUser = new Identity(params.get("login"),
                params.get("pass"),
                params.get("fname"),
                params.get("lname"),
                Integer.valueOf(params.get("age")));
        identityDao.save(newUser);
        return "redirect:/Administration/UserManagement";
    }
    @RequestMapping(value = "/Administration/UserManagement/PUT", method = {RequestMethod.GET, RequestMethod.PUT})
    public String objectUpdate(@RequestParam Map<String,String> params){
        Identity user = identityDao.findById(Long.valueOf(params.get("id")));
        if(!params.get("pass").equals("")) {
            user.setPassword(params.get("pass"));
        }
        user.setFirstName(params.get("fname"));
        user.setSecondName(params.get("lname"));
        user.setAge(Integer.valueOf(params.get("age")));
        identityDao.saveOrUpdate(user);
        return "redirect:/Administration/UserManagement";
    }
}
