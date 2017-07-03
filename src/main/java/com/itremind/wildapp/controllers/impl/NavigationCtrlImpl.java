package com.itremind.wildapp.controllers.impl;

import com.itremind.wildapp.controllers.NavigationCtrl;
import com.itremind.wildapp.controllers.beans.NavItem;
import com.itremind.wildapp.core.dao.NavigationDao;
import com.itremind.wildapp.core.model.Navigation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Borisovskiy.V on 21.06.2017.
 */
@Component
public class NavigationCtrlImpl implements NavigationCtrl{

    @Autowired
    private NavigationDao navigationDao;

    public NavigationCtrlImpl() {

    }

    public List<NavItem> getMainNavigation(){
        List<Navigation> navList = this.navigationDao.getNavByActive(Boolean.TRUE);
        List<NavItem> navItems = new ArrayList<NavItem>();
        for(Navigation nav : navList){
            navItems.add(new NavItem(nav.getName(), navigationDao.getItemURI(nav)));
        }
        return navItems;
    }
}
