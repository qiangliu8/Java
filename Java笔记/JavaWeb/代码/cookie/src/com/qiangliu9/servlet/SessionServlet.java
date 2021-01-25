package com.qiangliu9.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {

    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建和获取Session会话对象
        HttpSession httpSession = req.getSession();
        //判断当前Session是否是刚创建出来的
        boolean isNew = httpSession.isNew();
        //获取Session会话的唯一标识id
        String id = httpSession.getId();
        resp.getWriter().write("Session："+httpSession);
        resp.getWriter().write("SessionisNew："+isNew);
        resp.getWriter().write("Sessionid："+id);
    }
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("session1","valu1");
        resp.getWriter().write("session存进去了");
    }
    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object o =  req.getSession().getAttribute("session1");
        resp.getWriter().write("session1："+o);
    }
    protected void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int  time = req.getSession().getMaxInactiveInterval();
        resp.getWriter().write("session默认时长："+time);
    }
    protected void life3(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setMaxInactiveInterval(3);
        resp.getWriter().write("Session3秒超时销毁");
    }
    protected void deleteNow(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.getWriter().write("session时长为0.即Session马上销毁");
    }
}
