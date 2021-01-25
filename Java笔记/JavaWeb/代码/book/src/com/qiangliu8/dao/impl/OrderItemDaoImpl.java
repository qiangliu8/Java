package com.qiangliu8.dao.impl;

import com.qiangliu8.dao.BaseDao;
import com.qiangliu8.dao.OrderItemDao;
import com.qiangliu8.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item (name,count,price,total_price,order_id)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
