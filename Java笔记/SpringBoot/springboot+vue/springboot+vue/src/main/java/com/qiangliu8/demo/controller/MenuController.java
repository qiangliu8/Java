package com.qiangliu8.demo.controller;

import com.qiangliu8.demo.bean.MainMenu;
import com.qiangliu8.demo.bean.User;
import com.qiangliu8.demo.dao.MenuDao;
import com.qiangliu8.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {
    @Autowired
    private MenuDao menuDao;
    @RequestMapping(value = "/getAllMenus")
    public Object getAllMenus(){
        Map<String,Object> map = new HashMap<>();
        int status = 404 ;
        List<MainMenu> mainMenuList = menuDao.getMainMenus();
        if (mainMenuList!=null){
            map.put("status",200);
            map.put("data",mainMenuList);
        }
        return map;
    }
}
