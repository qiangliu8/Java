package com.qiangliu8.web;

import com.qiangliu8.pojo.User;
import com.qiangliu8.service.UserService;
import com.qiangliu8.service.impl.UserServiceImpl;
import com.qiangliu8.utils.CookieUtils;
import com.qiangliu8.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

public class UserServlet extends BaseServlet {
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//        try {
//            Method method = this.getClass().getDeclaredMethod(action,HttpServletRequest.class,HttpServletResponse.class);
//            method.invoke(this,req,resp);
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------登录业务-----------------");
        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        req.setAttribute("username",username);
        req.setAttribute("password",password);

        User user = userService.login(new User(null,username,password,null));
        if (user!=null){
            Cookie name = new Cookie("username",username);
            name.setMaxAge(60*60*24*7);
            Cookie pwd = new Cookie("password",password);
            pwd.setMaxAge(60*60*24*7);
            resp.addCookie(name);
            resp.addCookie(pwd);
            req.getSession().setAttribute("LoginUser",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }else{
            req.setAttribute("msg","账号或密码错误！");
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("-----------------注册业务-----------------");
        //获取Seesion的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        //删除服务器中的验证码
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        UserService userService = new UserServiceImpl();

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        req.setAttribute("username",username);
        req.setAttribute("password",password);
        req.setAttribute("email",email);
        req.setAttribute("code",code);
        Map<String,String[]> parameterMap = req.getParameterMap();
        for (Map.Entry<String,String[]> entry: parameterMap.entrySet()) {
            System.out.println(entry.getKey()+"="+ Arrays.asList(entry.getValue()));
        }
        User user = WebUtils.copyParamToBean(req.getParameterMap(),new User());

        System.out.println("注入之后"+user);

        if (token!=null&&token.equalsIgnoreCase(code)){

            if (userService.existUsername(user.getUsername())){
                req.setAttribute("msg","用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registerUser(user);
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            //跳回注册页面
            req.setAttribute("msg","验证码错误");
            System.out.println("验证码错误");
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }

    protected void isLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie nameCookie = CookieUtils.findCookie("username",req.getCookies());
//        if (nameCookie!=null){
//            req.getRequestDispatcher("/client/ClientBookServlet?action=page").forward(req,resp);
//        }else{
//            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
//        }
    }
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

}
