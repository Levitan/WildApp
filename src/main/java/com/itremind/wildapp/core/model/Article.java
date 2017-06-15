package com.itremind.wildapp.core.model;

import com.itremind.wildapp.core.utils.Transliterator;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */
@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "cat_id", nullable = false)
    private Long catId;

    @Column(name = "content", nullable = true, length = -1)
    private String content;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "alias", nullable = true, length = 255)
    private String alias;

    public Article() {
    }

    public Article(Long catId, String content, String name, Timestamp date, String alias) {
        this.catId = catId;
        this.content = content;
        this.name = name;
        this.date = date;
        this.alias = alias == null ? Transliterator.toLatin(name) : alias;;
    }

    public Long getId() {
        return id;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (catId != article.catId) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (name != null ? !name.equals(article.name) : article.name != null) return false;
        if (date != null ? !date.equals(article.date) : article.date != null) return false;
        if (alias != null ? !alias.equals(article.alias) : article.alias != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + catId.intValue();
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        return result;
    }
}
