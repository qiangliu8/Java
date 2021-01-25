package com.qiangliu9.servlet;

import com.qiangliu9.servlet.util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie:cookies){
            resp.getWriter().write("Cookie["+cookie.getName()+"="+cookie.getValue()+"]<br/>");
        }
    }
    protected void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建Cookie对象
        Cookie cookie1 = new Cookie("key1","value1");
        Cookie cookie2 = new Cookie("key2","value2");
        Cookie cookie3 = new Cookie("key3","value3");
        //通过客户端保存cookie
        resp.addCookie(cookie1);
        resp.addCookie(cookie2);
        resp.addCookie(cookie3);
        resp.getWriter().write("Cookie创建成功！");
    }
    protected void findCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.findCookie("key1",cookies);
        if (cookie!=null){
            resp.getWriter().write(cookie.getValue());
        }else {
            resp.getWriter().write("没找到Cookie");
        }
    }
    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        Cookie cookie = CookieUtils.findCookie("key2",cookies);
        cookie.setValue("asd");
        resp.addCookie(cookie);
        resp.getWriter().write("Cookie修改成功！");
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defautLife","defautLifeName");
        cookie.setMaxAge(-1); //设置存活时间 关闭浏览器cookie消失
        resp.addCookie(cookie);
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("defautLife",req.getCookies());
        cookie.setMaxAge(0); //立即删除
        resp.addCookie(cookie);
    }
    protected void life3600(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = CookieUtils.findCookie("defautLife",req.getCookies());
        cookie.setMaxAge(3600); //Cookie存活3600秒（1小时）
        resp.addCookie(cookie);
    }

    protected void testPath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1","value1");
        cookie.setPath(req.getContextPath()+"/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了代替有路径的cookie");
    }
}
