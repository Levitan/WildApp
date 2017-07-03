package com.itremind.wildapp.core.model;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 21.06.2017.
 */
@Entity
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "role", nullable = false, length = 50)
    private String role;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
