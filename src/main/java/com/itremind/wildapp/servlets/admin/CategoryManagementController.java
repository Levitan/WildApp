package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.model.Category;
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
public class CategoryManagementController implements ManagementController {

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "/Administration/Categories", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String,String> params, Model model){
        model.addAttribute(PAGE_TITLE, "Category Manager");

        if(params.get("delete") != null){
            categoryDao.delete(categoryDao.findById(Long.valueOf(params.get("delete"))));
            return "redirect:/Administration/Categories";
        }
        List<Category> categories = categoryDao.getAllCategories();
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
            Category category = categoryDao.findById(Long.valueOf(params.get("id")));
            model.addAttribute("cat", category);
            return "/admin/addcat";
        } else {
            return "redirect:/Administration/Categories";
        }
    }
    @RequestMapping(value = "/Administration/Categories/POST", method = RequestMethod.POST)
    public String objectAdd(@RequestParam Map<String, String> params) {
        Category category = new Category(params.get("name"),
                params.get("desc"),
                params.get("alias"));
        categoryDao.save(category);
        return "redirect:/Administration/Categories";
    }

    @RequestMapping(value = "/Administration/Categories/PUT", method = {RequestMethod.POST})
    public String objectUpdate(@RequestParam Map<String, String> params) {
        Category category = categoryDao.findById(Long.valueOf(params.get("id")));
        category.setName(params.get("name"));
        category.setDescription(params.get("desc"));
        categoryDao.saveOrUpdate(category);
        return "redirect:/Administration/Categories";
    }

}
