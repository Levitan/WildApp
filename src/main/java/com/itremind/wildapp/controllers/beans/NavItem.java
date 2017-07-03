package com.itremind.wildapp.controllers.beans;


/**
 * Created by Borisovskiy.V on 21.06.2017.
 */
public class NavItem{


    private String name;
    private String url;

    public NavItem(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
