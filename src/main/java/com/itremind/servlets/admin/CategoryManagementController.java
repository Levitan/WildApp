package com.itremind.servlets.admin;

import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.CategoryEntityManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class CategoryManagementController {

    CategoryEntityManager manager = CategoryEntityManager.getInstance();

    @RequestMapping(value = "/Administration/Categories", method = RequestMethod.GET)
    public String catList(@RequestParam Map<String,String> params, Model model){
        model.addAttribute("title", "Category Manager");
        CategoryEntityManager manager = CategoryEntityManager.getInstance();
        List<CategoryEntity> categories = manager.getAllCategories();
        model.addAttribute("cats", categories);
        return "/admin/catlist";
    }

    @RequestMapping(value = "/Administration/Categories/Manage", method = RequestMethod.GET)
    public String addCatView(@RequestParam Map<String,String> params, Model model){
        if(params.get("mode").equals("add")){
            model.addAttribute("title", "Add category");
            model.addAttribute("method", "POST");
            return "/admin/adduser";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute("title", "Edit user");
            model.addAttribute("method", "PUT");
            model.addAttribute("lock", "disable");
            CategoryEntity category = manager.getCategoryById(Integer.valueOf(params.get("id")));
            model.addAttribute("cat", category);
            return "/admin/adduser";
        } else {
            return "redirect:/Administration/UserManagement";
        }
    }
}
