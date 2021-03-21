package com.qiangliu8.demo.dao;

import com.qiangliu8.demo.bean.MainMenu;
import com.qiangliu8.demo.bean.SubMenu;
import com.qiangliu8.demo.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao {
    public List<MainMenu> getMainMenus();
}
