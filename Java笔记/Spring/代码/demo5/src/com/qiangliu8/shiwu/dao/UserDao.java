package com.qiangliu8.shiwu.dao;

public interface UserDao {
    public void addMoney(int money,String id);
    public void reduceMoney(int money,String id);
}
