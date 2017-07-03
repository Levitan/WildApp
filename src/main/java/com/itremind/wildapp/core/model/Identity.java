package com.itremind.wildapp.core.model;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
@Entity
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "age", nullable = true)
    private Integer age;


    @Column(name = "first_name", nullable = true, length = 32)
    private String firstName;

    @Column(name = "login", nullable = false, length = 50, unique = true)
    private String login;

    @Column(name = "password", nullable = false, length = 32)
    private String password;

    @Column(name = "second_name", nullable = true, length = 32)
    private String secondName;

    @Column(name = "enabled", nullable = false)
    private Boolean enable;


    public Identity() {
    }

    public Identity(String login, String password, String firstName, String secondName, Integer age) {
        this.firstName = firstName;
        this.login = login;
        this.password = DigestUtils.md5Hex(password);
        this.secondName = secondName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.md5Hex(password);
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identity identity = (Identity) o;

        if (!id.equals(identity.id)) return false;
        if (age != null ? !age.equals(identity.age) : identity.age != null) return false;
        if (firstName != null ? !firstName.equals(identity.firstName) : identity.firstName != null) return false;
        if (!login.equals(identity.login)) return false;
        if (!password.equals(identity.password)) return false;
        if (secondName != null ? !secondName.equals(identity.secondName) : identity.secondName != null) return false;
        return enable.equals(identity.enable);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        result = 31 * result + enable.hashCode();
        return result;
    }
}
