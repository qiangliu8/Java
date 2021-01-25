package com.qiangliu8.test;

import com.qiangliu8.dao.OrderItemDao;
import com.qiangliu8.dao.impl.OrderItemDaoImpl;
import com.qiangliu8.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoTest {
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null,"java直接放弃",1,new BigDecimal(100),new BigDecimal(100),"12345"));
    }
}