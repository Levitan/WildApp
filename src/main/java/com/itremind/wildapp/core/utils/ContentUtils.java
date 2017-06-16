package com.itremind.wildapp.core.utils;

/**
 * Created by Borisovskiy.V on 16.06.2017.
 */
public class ContentUtils {
    public static final int perPage = 5;

    public static int getPageCount(int total){
        double a = (double) total / ContentUtils.perPage;
        int b = (int) a;
        if(a - b > 0){
            b += 1;
        }
        return b;
    }
}
