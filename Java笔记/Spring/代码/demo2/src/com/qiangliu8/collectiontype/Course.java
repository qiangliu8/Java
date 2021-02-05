package com.qiangliu8.collectiontype;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Course {
    private String cname;
    //List集合类型属性
    private List<String> list;
    //Map集合类型属性
    private Map<String,String> map;
    //Set集合类型属性
    private Set<String> set;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                ", list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
