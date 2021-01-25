package com.qiangliu8.ThreadLocal;

public class OrderService {
    public void createOrder(){
        String name = Thread.currentThread().getName();
        System.out.println("当前线程保存的数据"+ThreadLocalTest.threadLocal.get());
    }
}
