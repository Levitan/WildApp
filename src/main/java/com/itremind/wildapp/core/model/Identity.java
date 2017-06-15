package com.itremind.wildapp.core.model;

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

    @Basic
    @Column(name = "age", nullable = true)
    private Integer age;

    @Basic
    @Column(name = "first_name", nullable = true, length = 32)
    private String firstName;
    @Basic
    @Column(name = "login", nullable = false, length = 50)
    private String login;
    @Basic
    @Column(name = "password", nullable = false, length = 32)
    private String password;
    @Basic
    @Column(name = "second_name", nullable = true, length = 32)
    private String secondName;


    public Identity() {
    }

    public Identity(String login, String password, String firstName, String secondName, Integer age) {
        this.firstName = firstName;
        this.login = login;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Identity identity = (Identity) o;

        if (id != identity.id) return false;
        if (age != null ? !age.equals(identity.age) : identity.age != null) return false;
        if (firstName != null ? !firstName.equals(identity.firstName) : identity.firstName != null) return false;
        if (login != null ? !login.equals(identity.login) : identity.login != null) return false;
        if (password != null ? !password.equals(identity.password) : identity.password != null) return false;
        if (secondName != null ? !secondName.equals(identity.secondName) : identity.secondName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.intValue();
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (secondName != null ? secondName.hashCode() : 0);
        return result;
    }
}
