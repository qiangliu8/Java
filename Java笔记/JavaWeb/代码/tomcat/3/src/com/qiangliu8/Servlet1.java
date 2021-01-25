package com.qiangliu8;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Servlet1")
public class Servlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("在Servlet1查看材料"+request.getParameter("username"));
        request.setAttribute("username",request.getParameter("username"));
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/3_Servlet2");

        requestDispatcher.forward(request,response);
    }
}
