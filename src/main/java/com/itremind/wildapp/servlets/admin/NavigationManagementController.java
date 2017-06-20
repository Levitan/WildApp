package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.ArticleDao;
import com.itremind.wildapp.core.dao.CategoryDao;
import com.itremind.wildapp.core.dao.NavigationDao;
import com.itremind.wildapp.core.model.Category;
import com.itremind.wildapp.core.model.Navigation;
import com.itremind.wildapp.core.utils.Toast;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 04.06.2017.
 */
@Controller
public class NavigationManagementController<E> implements ManagementController {

    @Autowired
    NavigationDao navigationDao;
    @Autowired
    CategoryDao categoryDao;
    @Autowired
    ArticleDao articleDao;

    private static final String[] TYPES = {"Article", "Category", "Page"};

    @RequestMapping(value = "/Administration/Menu", method = RequestMethod.GET)
    public String mainView(@RequestParam Map<String, String> params, Model model) {
        if (params.get("delete") != null) {
            navigationDao.delete(navigationDao.findById(Long.valueOf(params.get("delete"))));
            return "redirect:/Administration/Menu";
        }
        List<Navigation> menus = navigationDao.getAllNav();
        List<String> names = new ArrayList<String>();
        for(Navigation nav : menus){
            if(nav.getType() == Navigation.ARTICLE){
                names.add(articleDao.findById(nav.getContentId()).getName());
            } else if (nav.getType() == Navigation.CATEGORY){
                names.add(categoryDao.findById(nav.getContentId()).getName());
            }
        }
        model.addAttribute("menus", menus);
        model.addAttribute("names", names);
        model.addAttribute(PAGE_TITLE, "Menu management");
        model.addAttribute("TYPES", TYPES);
        return "/admin/menulist";
    }

    @RequestMapping(value = "/Administration/Menu/Manage", method = RequestMethod.GET)
    public String addView(@RequestParam Map<String, String> params, Model model) {
        if (params.get("mode").equals("add")) {
            model.addAttribute(PAGE_TITLE, "Add menu");
            model.addAttribute("method", "POST");
            model.addAttribute("TYPES", TYPES);
            return "/admin/addmenu";
        } else if (params.get("mode").equals("edit")) {
            Navigation menu = navigationDao.findById(Long.valueOf(params.get("id")));

            model.addAttribute(PAGE_TITLE, "Edit menu");
            model.addAttribute("method", "PUT");
            model.addAttribute("menu", menu);
            model.addAttribute("TYPES", TYPES);
            return "/admin/addmenu";
        } else if (params.get("mode").equals("enable")) {
            Navigation menu = navigationDao.findById(Long.valueOf(params.get("id")));

            if (menu.isEnable()) {
                menu.setEnable(Boolean.FALSE);
            } else {
                menu.setEnable(Boolean.TRUE);
            }
            navigationDao.saveOrUpdate(menu);
            return "redirect:/Administration/Menu";
        } else {
            return "redirect:/Administration/Menu";
        }
    }

    @RequestMapping(value = "/Administration/Menu/POST")
    public String objectAdd(@RequestParam Map<String, String> params) {
        Navigation nav = new Navigation(Long.valueOf(params.get("contentId")),
                params.get("enabled").equals("on") ? Boolean.TRUE: Boolean.FALSE,
                params.get("name"),
                Integer.valueOf(params.get("type")));
        navigationDao.save(nav);
        return "redirect:/Administration/Menu";
    }

    @RequestMapping(value = "/Administration/Menu/PUT")
    public String objectUpdate(@RequestParam Map<String, String> params) {
//        Navigation nav = navigationDao.findById(params)
        return null;
    }

    @RequestMapping(value = "/Administration/Menu/Type",
            method = RequestMethod.GET,
            produces = "application/json")
    public @ResponseBody
    List<Object> getContent(@RequestParam("contentT") int type) {
        if (type == Navigation.ARTICLE) {
            return articleDao.findAll();
        } else if (type == Navigation.CATEGORY) {
            return categoryDao.findAll();
        }
        return new ArrayList<Object>();
    }
}
