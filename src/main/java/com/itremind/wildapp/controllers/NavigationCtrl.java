package com.itremind.wildapp.controllers;

import com.itremind.wildapp.controllers.beans.NavItem;

import java.util.List;

/**
 * Created by Borisovskiy.V on 21.06.2017.
 */
public interface NavigationCtrl {
    List<NavItem> getMainNavigation();
}
