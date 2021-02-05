package com.qiangliu8.dao;

import com.qiangliu8.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.print.attribute.standard.JobKOctets;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void addUser(User user) {
        //1.创建sql语句
        String sql = "insert into t_user (userId,username,ustatus) values(?,?,?)";
        //调用方法实现
        Object [] args ={user.getUserId(),user.getUsername(), user.getUstatus()};
        int update =  jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void updateUser(User user) {
        String sql ="update t_user set username = ?,ustatus=? where userId = ?";
        Object[] args = {user.getUsername(),user.getUstatus(),user.getUserId()};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from t_user where userId = ?";
        Object[] args = {id};
        int update = jdbcTemplate.update(sql,args);
        System.out.println(update);

    }

    @Override
    public int selectCount() {
        String sql = "select count(*) from t_user";
        int count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;
    }

    @Override
    public User findUserInfo(String id) {
        String sql = "select * from t_user where UserId = ?";
        User user = jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),id);
        return user;
    }

    @Override
    public List<User> findUserAllList() {
        String sql = "select * from t_user";
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<User>(User.class));
        return list;
    }

    @Override
    public void batchAdd(List<Object[]> batchArgs) {
        String sql = "insert into t_user (userId,username,ustatus) values(?,?,?)";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchUpdate(List<Object[]> batchArgs) {
        String sql ="update t_user set username = ?,ustatus=? where userId = ?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Override
    public void batchDelete(List<Object[]> batchArgs) {
        String sql ="delete from t_user where userId= ?";
        int[] ints = jdbcTemplate.batchUpdate(sql,batchArgs);
        System.out.println(Arrays.toString(ints));
    }
}
