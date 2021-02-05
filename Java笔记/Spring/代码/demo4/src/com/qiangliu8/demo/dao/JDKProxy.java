package com.qiangliu8.demo.dao;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JDKProxy {
    public static void main(String[] args) {
        //创建接口实现类代理对象
        Class[] interfaces={UserDao.class};

        UserDao userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(),interfaces,new UserDaoProxy(userDao));
        System.out.println(dao.add(1,2));
    }
}

//创建代理对象代码
class UserDaoProxy implements InvocationHandler {
    //把创建的是谁的代理对象，把谁传递过来
    //有参构造传递
    private Object object;
    public UserDaoProxy(Object obj){
        this.object = obj;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       //方法之前
        System.out.println("方法之前执行...."+method.getName()+":传递的参数..."+ Arrays.toString(args));

        //被增江的方法执行
        Object object1 =  method.invoke(object,args);

        if ("add".equals(method.getName())){
            System.out.println("add方法执行了");
        }else{
            System.out.println("update方法执行了");
        }
        //方法之后
        System.out.println("方法之后执行..."+object);

        return object1;
    }
}