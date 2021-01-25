package com.qiangliu8.web;

import com.qiangliu8.pojo.User;
import com.qiangliu8.service.UserService;
import com.qiangliu8.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password =  req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");
        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.setAttribute("email",email);
        req.setAttribute("code",code);
        if ("abcde".equalsIgnoreCase(code)){

            if (userService.existUsername(username)){
                req.setAttribute("msg","用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registerUser(new User(null,username,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }

        }else{
            //跳回注册页面
            req.setAttribute("msg","验证码错误");
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }

    }
}
