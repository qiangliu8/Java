package com.qiangliu8.demo.dao;

import org.springframework.stereotype.Repository;

@Repository(value = "userDaoImpl1")
public class userDaoImpl implements userDao{
    @Override
    public void add() {
        System.out.println("dao add....");
    }
}
