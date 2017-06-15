package com.itremind.wildapp.core.utils;

/**
 * Created by vlevi on 25.05.2017.
 */
public class Toast {
    public static final String TYPE_INFO = "info";
    public static final String TYPE_SUCCESS = "success";
    public static final String TYPE_WARN = "warning";
    public static final String TYPE_ERROR = "error";

    private String title;
    private String description;
    private String type;
    private Boolean enable = Boolean.TRUE;

    public Toast(String title, String description, String type, Boolean enable) {
        this.title = title;
        this.description = description;
        this.type = type;
        this.enable = enable;
    }

    public Toast(String title, String description, String type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
