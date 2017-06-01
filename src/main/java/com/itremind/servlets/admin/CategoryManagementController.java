package com.itremind.servlets.admin;

import com.itremind.entities.CategoryEntity;
import com.itremind.entitymanagers.CategoryEntityManager;
import com.itremind.servlets.admin.interfaces.ManagementController;
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
public class CategoryManagementController implements ManagementController {

    CategoryEntityManager manager = CategoryEntityManager.getInstance();

    @RequestMapping(value = "/Administration/Categories", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String,String> params, Model model){
        model.addAttribute(PAGE_TITLE, "Category Manager");
        if(params.get("delete") != null){
            manager.delete(manager.getCategoryById(Integer.valueOf(params.get("delete"))));
            return "redirect:/Administration/Categories";
        }
        CategoryEntityManager manager = CategoryEntityManager.getInstance();
        List<CategoryEntity> categories = manager.getAllCategories();
        model.addAttribute("cats", categories);
        return "/admin/catlist";
    }

    @RequestMapping(value = "/Administration/Categories/Manage", method = RequestMethod.GET)
    public String addView(@RequestParam Map<String,String> params, Model model){
        if(params.get("mode").equals("add")){
            model.addAttribute(PAGE_TITLE, "Add category");
            model.addAttribute("method", "POST");
            return "/admin/addcat";
        } else if (params.get("mode").equals("edit")){
            model.addAttribute(PAGE_TITLE, "Edit user");
            model.addAttribute("method", "PUT");
            model.addAttribute("lock", "disable");
            CategoryEntity category = manager.getCategoryById(Integer.valueOf(params.get("id")));
            model.addAttribute("cat", category);
            return "/admin/addcat";
        } else {
            return "redirect:/Administration/Categories";
        }
    }
    @RequestMapping(value = "/Administration/Categories/POST", method = RequestMethod.POST)
    public String objectAdd(@RequestParam Map<String, String> params) {
        CategoryEntity category = new CategoryEntity(params.get("name"), params.get("desc"));
        manager.create(category);
        return "redirect:/Administration/Categories";
    }

    @RequestMapping(value = "/Administration/Categories/PUT", method = {RequestMethod.GET, RequestMethod.PUT})
    public String objectUpdate(@RequestParam Map<String, String> params) {
        CategoryEntity category = manager.getCategoryById(Integer.valueOf(params.get("id")));
        category.setName(params.get("name"));
        category.setDescription(params.get("desc"));
        return "redirect:/Administration/Categories";
    }

}
