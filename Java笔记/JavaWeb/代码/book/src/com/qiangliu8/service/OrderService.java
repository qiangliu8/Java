package com.qiangliu8.service;

import com.qiangliu8.pojo.Cart;

public interface OrderService {
    public String createOrder(Cart cart, Integer userId);
}
