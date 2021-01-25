package com.qiangliu8;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ResponseIOServlet")
public class ResponseIOServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        //设置服务器字符集为UTF-8
//        response.setCharacterEncoding("UTF-8");
//        //通过响应头，设置浏览器使用UTF-8
//        response.setHeader("Content-type","text/html;charset=UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("俞文竹");
    }
}
