package com.qiangliu8.demo.bean;

import java.util.List;

public class MainMenu {
    private int id;
    private String title;
    private String path;
    private List<SubMenu> subMenuList;

    @Override
    public String toString() {
        return "MainMenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", subMenuList=" + subMenuList +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<SubMenu> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<SubMenu> subMenuList) {
        this.subMenuList = subMenuList;
    }

    public MainMenu() {
    }

    public MainMenu(String title, String path, List<SubMenu> subMenuList) {
        this.title = title;
        this.path = path;
        this.subMenuList = subMenuList;
    }
}
