package com.qiangliu8.serlvet.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class myListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("ServletContextListener对象初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("ServletContextListener对象销毁");
    }
}
