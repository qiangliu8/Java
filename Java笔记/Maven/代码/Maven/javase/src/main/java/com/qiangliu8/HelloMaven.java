package com.qiangliu8;

public class HelloMaven {
    public int add (int n1,int n2){
        return n1+n2;
    }

    public static void main(String[] args) {
        HelloMaven helloMaven = new HelloMaven();
        System.out.println(helloMaven.add(10,20));
    }
}
