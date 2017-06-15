package com.itremind.wildapp.core.utils;

import org.hibernate.dialect.MySQL5InnoDBDialect;

/**
 * Created by Borisovskiy.V on 15.06.2017.
 */
public class CustomMySQLDialect extends MySQL5InnoDBDialect {
    public String getTableTypeString(){
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}
