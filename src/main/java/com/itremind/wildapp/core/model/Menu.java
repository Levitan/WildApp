package com.itremind.wildapp.core.model;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Entity
public class Menu {

    private static final int ARTICLE = 0;
    private static final int CATEGORY = 1;
    private static final int PAGE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable=false)
    String name;

    @Column(name = "type", nullable = false)
    Integer type;

    @Column(name = "content_id", nullable = false)
    Long contentId;

    @Column(name = "enable", nullable = false)
    Boolean isEnable;

    public Menu() {
    }

    public Menu(String name, Integer type, Long contentId, Boolean isEnable) {
        this.name = name;
        this.type = type;
        this.contentId = contentId;
        this.isEnable = isEnable;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Boolean isEnable() {
        return isEnable;
    }

    public void setEnable(Boolean enable) {
        isEnable = enable;
    }
}
