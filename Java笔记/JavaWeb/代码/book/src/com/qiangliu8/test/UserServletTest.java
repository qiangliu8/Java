package com.qiangliu8.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServletTest {
    public void login(){
        System.out.println("这是login方法");
    }
    public void regist(){
        System.out.println("这是regist方法");
    }
    public void updateUser(){
        System.out.println("这是updateUser方法");
    }
    public void updateUserPassword(){
        System.out.println("这是updateUserPassword方法");
    }

    public static void main(String[] args) {
        String action = "regist";

        try {
            //获取action业务鉴别字符串，获取相应的业务方法 反射对象
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            //调用目标业务方法
            method.invoke(new UserServletTest());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
