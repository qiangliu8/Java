package com.qiangliu8.dao.impl;

import com.qiangliu8.dao.BaseDao;
import com.qiangliu8.dao.OrderDao;
import com.qiangliu8.pojo.Order;

import java.util.Date;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
       String sql = "insert into t_order(order_id,create_time,price,status,user_id)values(?,?,?,?,?)";
       return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
