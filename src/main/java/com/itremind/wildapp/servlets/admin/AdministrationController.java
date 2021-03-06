package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.utils.RPApi;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import com.itremind.wildapp.core.utils.Toast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Properties;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class AdministrationController implements ManagementController {

//    @Autowired
//    private CategoryDao categoryDao;

    @RequestMapping(value = "/Administration", method = RequestMethod.GET)
    public String administration(@RequestParam Map<String, String> params, Model model) {
//        List<Category> cats = categoryDao.getAllCategories();
        model.addAttribute(PAGE_TITLE, "Main page");
        Properties str = System.getProperties();
        String p = System.getProperty("program.name");
        Toast t = new Toast("Install", "good", Toast.TYPE_SUCCESS);
        model.addAttribute("toast", t);
        return "/admin/admin";

    }

    public String mainView(Map<String, String> params, Model model) {
        return null;
    }

    public String addView(Map<String, String> params, Model model) {
        return null;
    }

    public String objectAdd(Map<String, String> params) {
        return null;
    }

    public String objectUpdate(Map<String, String> params) {
        return null;
    }
}
