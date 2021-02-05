package com.qiangliu8.spring5;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
        System.out.println(123);
    }

    public void add(){
        System.out.println("add....");
    }
}
