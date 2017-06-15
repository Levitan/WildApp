package com.itremind.wildapp.servlets.admin.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Borisovskiy.V on 25.05.2017.
 */
@Controller
public class ImageUploadController {

    private static final Logger logger = LoggerFactory.getLogger(ImageUploadController.class);

    @RequestMapping(value = "/Administration/Articles/Upload", method = RequestMethod.POST)
    public @ResponseBody String uploadFileHandler(@RequestParam("name") String name,
                                                  @RequestParam("file") MultipartFile file,
                                                  @RequestParam("width") Integer width,
                                                  HttpSession session){
        if(!file.isEmpty()){
            try {
                byte[] bytes = file.getBytes();
                String rootPath;
                if(System.getProperty("jboss.home.dir") != null){
                    rootPath = System.getProperty("jboss.home.dir");
                } else if (System.getProperty("catalina.home") != null){
                    rootPath = System.getProperty("catalina.home");
                } else {
                    rootPath = System.getProperty("user.dir");
                }
                File dir = new File(rootPath + File.separator + "/appContent/wildapp/uploads");
                if(!dir.exists()){
                    dir.mkdirs();
                }
                File serverFile = new File(dir.getAbsolutePath() + File.separator + name + ".jpg");
                if(serverFile.exists()){
                    serverFile = new File(dir.getAbsolutePath() + File.separator + name + "0" + ".jpg");
                }
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
                if(width != null) {
                    return "<img src=\"/wildapp/uploads/" + name + ".jpg\" style=\"width:" + width + "px;\" >";
                } else {
                    return "<img src=\"/wildapp/uploads/" + name + ".jpg\" style=\"width:100%;\" >";
                }
            } catch (IOException e) {

                return "redirect:/Administration/Articles/Manage?mode=add";
            }
        } else {

            return "redirect:/Administration/Articles/Manage?mode=add";
        }
    }
}
