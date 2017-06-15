package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.dao.MenuDao;
import com.itremind.wildapp.core.model.Menu;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 04.06.2017.
 */
@Controller
public class MenuManagementController implements ManagementController{

    @Autowired
    MenuDao menuDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ArticleDao articleDao;

    private static final String[] TYPES = {"Article", "Category", "Page"};

    @RequestMapping(value = "/Administration/Menu")
    public String mainView(@RequestParam Map<String, String> params, Model model) {
        if(params.get("delete") != null){
            menuDao.delete(menuDao.findById(Long.valueOf(params.get("delete"))));
            return "redirect:/Administration/Menu";
        }
        List<Menu> menus = menuDao.getAllMenu();

        model.addAttribute("menus", menus);
        model.addAttribute(PAGE_TITLE, "Menu management");
        model.addAttribute("TYPES", TYPES);
        return "/admin/menulist";
    }
    @RequestMapping(value = "/Administration/Menu/Manage")
    public String addView(@RequestParam Map<String, String> params, Model model) {
        if (params.get("mode").equals("add")){
            model.addAttribute(PAGE_TITLE, "Add menu");
            model.addAttribute("method", "POST");
            model.addAttribute("TYPES", TYPES);
            return "/admin/addmenu";
        } else if(params.get("mode").equals("edit")){
            Menu menu = menuDao.findById(Long.valueOf(params.get("id")));

            model.addAttribute(PAGE_TITLE, "Edit menu");
            model.addAttribute("method", "PUT");
            model.addAttribute("menu", menu);
            model.addAttribute("TYPES", TYPES);
            return "/admin/addmenu";
        } else {
            return "redirect:/Administration/Menu";
        }
    }
    @RequestMapping(value = "/Administration/Menu/POST")
    public String objectAdd(@RequestParam Map<String, String> params) {
        return null;
    }
    @RequestMapping(value = "/Administration/Menu/PUT")
    public String objectUpdate(@RequestParam Map<String, String> params) {
        return null;
    }
}
