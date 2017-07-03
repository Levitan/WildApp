package com.itremind.wildapp.core.model;

import javax.persistence.*;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
@Entity
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "property", nullable = false, length = 50, unique = true)
    private String property;

    @Column(name = "value", nullable = false, length = 50)
    private String value;

    public int getId() {
        return id;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Property property1 = (Property) o;

        if (id != property1.id) return false;
        if (!property.equals(property1.property)) return false;
        return value.equals(property1.value);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + property.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }
}
