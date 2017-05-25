package com.itremind.servlets.admin;

import com.itremind.utils.Toast;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class AdministrationController {

    @RequestMapping(value = "/Administration", method = RequestMethod.GET)
    public String administration(@RequestParam Map<String, String> params, Model model) {
        model.addAttribute("title", "Main page");
        Toast t = new Toast("Install", "Good", Toast.TYPE_SUCCESS);
//        model.addAttribute("toast", t);
        return "/admin/admin";

    }
}
