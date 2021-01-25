package com.qiangliu8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Resopne1")
public class Resopne1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Resopne1到此一游");
        //设置状态码
        response.setStatus(302);
        //设置响应头，说明跳转到那里
        response.setHeader("Location","http://localhost:8083/3_war_exploded/3_Servlet2");
//        response.sendRedirect("http://localhost:8083/3_war_exploded/Resopne1");
    }
}
