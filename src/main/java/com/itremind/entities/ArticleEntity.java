package com.itremind.entities;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 22.05.2017.
 */

@Entity
@Table(name = "Article", schema = "wildapp", catalog = "")
public class ArticleEntity {
    private int id;
    private String name;
    private String content;
    private int catId;

    public ArticleEntity() {
    }

    public ArticleEntity(String name, String content, int catId) {
        this.name = name;
        this.content = content;
        this.catId = catId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "content", nullable = true, columnDefinition = "TEXT", length = -1)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "cat_id", nullable = false)
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ArticleEntity that = (ArticleEntity) o;

        if (id != that.id) return false;
        if (catId != that.catId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + catId;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
