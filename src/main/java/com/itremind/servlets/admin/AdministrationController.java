package com.itremind.servlets.admin;

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
import java.util.Map;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */
@Controller
public class AdministrationController {

    @RequestMapping(value = "/Administration", method = RequestMethod.GET)
    public String administration(@RequestParam Map<String,String> params, Model model){
        model.addAttribute("title", "Main page");
        return "/admin/admin";

    }
}
