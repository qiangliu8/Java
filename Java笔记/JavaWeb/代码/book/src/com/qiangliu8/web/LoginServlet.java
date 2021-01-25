package com.qiangliu8.web;

import com.qiangliu8.pojo.User;
import com.qiangliu8.service.UserService;
import com.qiangliu8.service.impl.UserServiceImpl;
import com.qiangliu8.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.security.cert.CertificateParsingException;

public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(null,username,password,null));
        System.out.println(user);
        if (user!=null){
            Cookie name = new Cookie("username",username);
            name.setMaxAge(60*60*24*7);
            Cookie pwd = new Cookie("password",password);
            pwd.setMaxAge(60*60*24*7);
            resp.addCookie(name);
            resp.addCookie(pwd);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","账号或者密码错误！");
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            System.out.println("登录失败！");
        }
    }
    protected void isLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie nameCookie = CookieUtils.findCookie("name",req.getCookies());
        if (nameCookie!=null){
            resp.sendRedirect("/page/user");
        }
    }

}
