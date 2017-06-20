package com.itremind.wildapp.core.model;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 20.06.2017.
 */
@Entity
public class Navigation {


    public static final int ARTICLE = 0;
    public static final int CATEGORY = 1;
    public static final int PAGE = 2;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "content_id", nullable = false)
    private Long contentId;

    @Column(name = "enable", nullable = false)
    private Boolean enable;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "n_order", nullable = true)
    private Integer nOrder;

    @Column(name = "type", nullable = false)
    private int type;


    public Navigation(Long contentId, Boolean enable, String name, Integer nOrder, int type) {
        this.contentId = contentId;
        this.enable = enable;
        this.name = name;
        this.nOrder = nOrder;
        this.type = type;
    }

    public Navigation(Long contentId, Boolean enable, String name, int type) {
        this.contentId = contentId;
        this.enable = enable;
        this.name = name;
        this.type = type;
        this.nOrder = 10;
    }

    public Navigation() {
    }

    public Long getId() {
        return id;
    }

    public Long getContentId() {
        return contentId;
    }

    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public Boolean isEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Navigation that = (Navigation) o;

        if (id != that.id) return false;
        if (contentId != that.contentId) return false;
        if (enable != that.enable) return false;
        if (type != that.type) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (nOrder != null ? !nOrder.equals(that.nOrder) : that.nOrder != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (contentId ^ (contentId >>> 32));
        result = 31 * result + (enable ? 1 : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (nOrder != null ? nOrder.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }
}
