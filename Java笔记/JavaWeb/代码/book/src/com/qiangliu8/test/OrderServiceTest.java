package com.qiangliu8.test;

import com.qiangliu8.pojo.Cart;
import com.qiangliu8.pojo.CartItem;
import com.qiangliu8.service.OrderService;
import com.qiangliu8.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"我惹你小强",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"我惹你小强",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"我惹你小俞",2,new BigDecimal(1000),new BigDecimal(2000)));
        System.out.println(orderService.createOrder(cart,1));
    }
}