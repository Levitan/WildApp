package com.itremind.wildapp.servlets.admin;

import com.itremind.wildapp.core.dao.PropertyDao;
import com.itremind.wildapp.core.model.Property;
import com.itremind.wildapp.servlets.admin.interfaces.ManagementController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.ws.RequestWrapper;
import java.util.List;
import java.util.Map;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Controller
public class PropertyManagementController implements ManagementController {

    @Autowired
    PropertyDao propertyDao;

    @RequestMapping("/Administration/Property")
    public String mainView(Map<String, String> params, Model model) {
        List<Property> properties = propertyDao.getAllProperties();

        model.addAttribute("properties", properties);
        model.addAttribute(PAGE_TITLE, "System properties");
        return "/admin/property";
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
