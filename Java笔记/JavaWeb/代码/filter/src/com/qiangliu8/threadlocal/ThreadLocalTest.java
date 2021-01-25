package com.qiangliu8.threadlocal;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadLocalTest {
    public final static Map<String,Object> data = new ConcurrentHashMap<String,Object>();

    private static  Random random = new Random();

    public class Task implements Runnable{

        @Override
        public void run() {
            //run方法中随机生成一个变量（线程要关联的数据），然后以当前线程名为key保存到map中
            Integer i = random.nextInt(1000);
            //获取当前线程名
            String name = Thread.currentThread().getName();
            System.out.println("线程名："+name+" 随机数："+i);
            data.put(name,i);
            Thread.sleep(5000);
            //在run方法结束之前，以当前线程名获取出数据并打印，查看是哦福可以取出操作
            Object object = data.get(name);
            System.out.println(name+"线程"+"关联的数据为"+o);
        }
    }
    public  static public static void main(String[] args) {
        for (int i = 0; i <3 ; i++) {
            new Thread(new Task()).start();
        }
    }
}
