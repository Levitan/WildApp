package com.itremind.servlets.admin.interfaces;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by vlevi on 25.05.2017.
 */
public interface ManagementController {
    String PAGE_TITLE = "title";
    String mainView(@RequestParam Map<String,String> params, Model model);
    String addView(@RequestParam Map<String,String> params, Model model);
    String objectAdd(@RequestParam Map<String,String> params);
    String objectUpdate(@RequestParam Map<String,String> params);
}
