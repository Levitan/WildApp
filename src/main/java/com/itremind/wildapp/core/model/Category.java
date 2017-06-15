package com.itremind.wildapp.core.model;


import com.itremind.wildapp.core.utils.Transliterator;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 08.06.2017.
 */

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name", nullable = false, length = 50)
    String name;

    @Column(name = "description", nullable = true, length = 255)
    String description;

    @Column(name = "alias", nullable = false, length = 50)
    String alias;

    public Category() {}

    public Category(String name, String description, String alias) {
        this.name = name;
        this.description = description;
        this.alias = alias == null ? Transliterator.toLatin(name) : alias;;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }
}
