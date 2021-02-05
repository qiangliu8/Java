package com.qiangliu8.collectiontype.bean;

public class Order {
    private String  oname;

    public Order() {
        System.out.println("第一步，执行无参构造函数创建bean实例！");
    }

    public void setOname(String oname) {
        this.oname = oname;
        System.out.println("第二步，调用set方法设置属性的值");
    }
    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化的方法");
    }
    public void destoryMethod(){
        System.out.println("第五步，执行销毁的方法");
    }
}
