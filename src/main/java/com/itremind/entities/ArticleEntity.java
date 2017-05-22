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
    @Column(name = "content", nullable = true, columnDefinition = "TEXT")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "cat_id", nullable = true)
    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }
}
