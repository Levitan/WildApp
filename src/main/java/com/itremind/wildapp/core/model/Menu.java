package com.itremind.wildapp.core.model;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Entity
public class Menu {

    public static final int ARTICLE = 0;
    public static final int CATEGORY = 1;
    public static final int PAGE = 2;

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

    @Column(name = "order", nullable = true)
    Integer order;

    public Menu() {
    }

    public Menu(String name, Integer type, Long contentId, Boolean isEnable) {
        this.name = name;
        this.type = type;
        this.contentId = contentId;
        this.isEnable = isEnable;
        this.order = 10;
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

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (!id.equals(menu.id)) return false;
        if (!name.equals(menu.name)) return false;
        if (!type.equals(menu.type)) return false;
        if (!contentId.equals(menu.contentId)) return false;
        if (!isEnable.equals(menu.isEnable)) return false;
        return order != null ? order.equals(menu.order) : menu.order == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + type.hashCode();
        result = 31 * result + contentId.hashCode();
        result = 31 * result + isEnable.hashCode();
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }
}
