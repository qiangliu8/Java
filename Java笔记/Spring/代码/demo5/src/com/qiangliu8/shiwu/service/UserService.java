package com.qiangliu8.shiwu.service;

import com.qiangliu8.shiwu.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.REPEATABLE_READ)
public class UserService {
    @Autowired
    private UserDao userDao;
    public void accountMoney(String id1,String id2,int money){
        userDao.addMoney(money,id1);
        int s = 1/0;
        userDao.reduceMoney(money,id2);
    }
}
