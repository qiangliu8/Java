package com.qiangliu8.test;

import com.qiangliu8.pojo.Cart;
import com.qiangliu8.pojo.CartItem;
import org.junit.Test;

import java.lang.management.BufferPoolMXBean;
import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {


    private Integer id;
    private String name;
    private Integer count;
    private BigDecimal price;
    private BigDecimal totalPrice;
    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"我惹你小强",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"我惹你小强",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"我惹你小俞",2,new BigDecimal(1000),new BigDecimal(2000)));
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"我惹你小强",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"我惹你小强",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"我惹你小俞",2,new BigDecimal(1000),new BigDecimal(2000)));

        cart.updateCount(1,10);
        System.out.println(cart);
    }

    @Test
    public void deleteItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"我惹你小强",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"我惹你小强",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"我惹你小俞",2,new BigDecimal(1000),new BigDecimal(2000)));

        cart.deleteItem(1);

        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"我惹你小强",1,new BigDecimal(100),new BigDecimal(100)));
        cart.addItem(new CartItem(1,"我惹你小强",2,new BigDecimal(100),new BigDecimal(200)));
        cart.addItem(new CartItem(2,"我惹你小俞",2,new BigDecimal(1000),new BigDecimal(2000)));

        cart.clear();

        System.out.println(cart);
    }
}