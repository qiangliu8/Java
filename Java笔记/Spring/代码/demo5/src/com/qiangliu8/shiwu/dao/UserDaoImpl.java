package com.qiangliu8.shiwu.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void reduceMoney(int money,String id) {
        String sql = "update t_account set money = money-? where id = ?";
        jdbcTemplate.update(sql,money,id);
    }

    @Override
    public void addMoney(int money,String id) {
        String sql = "update t_account set money = money+? where id = ?";
        jdbcTemplate.update(sql,money,id);
    }
}
