package com.qiangliu8;

import org.junit.Assert;
import org.junit.Test;

public class HelloMavenTest {
    @Test
    public void addTest(){
        HelloMaven helloMaven = new HelloMaven();
        int res = helloMaven.add(10,20);
        System.out.println(res);
        Assert.assertEquals(res,30);
    }
}
