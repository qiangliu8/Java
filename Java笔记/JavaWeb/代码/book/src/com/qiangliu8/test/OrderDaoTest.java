package com.qiangliu8.test;

import com.qiangliu8.dao.OrderDao;
import com.qiangliu8.dao.impl.OrderDaoImpl;
import com.qiangliu8.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.BitSet;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoTest {
    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {
        orderDao.saveOrder(new Order("1222345",new Date(),new BigDecimal(100),0,1));
    }
}