package com.qiangliu8.demo.dao;

import com.qiangliu8.demo.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserbyMessage(@Param("username") String username, @Param("password") String password);
    public List<User> getUserList(@Param("username") String username,@Param("pageStart") int PageStart,@Param("pageSize") int pageSize);
    public User getUserById(Integer id);
    public int getUserCounts(@Param("username") String username);
    public Integer updateState(Integer id,Boolean state);
    public Integer addUser(User user);
    public Integer deleteUser(int id);
    public Integer updateUser(User user);
}
