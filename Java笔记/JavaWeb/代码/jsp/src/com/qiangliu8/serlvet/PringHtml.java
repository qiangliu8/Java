package com.qiangliu8.serlvet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class PringHtml extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过响应流回传数据
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = resp.getWriter();

        printWriter.write("<!DOCTYPE html>\r\n");
        printWriter.write("<html lang=\"en\">\n");
        printWriter.write("<head>\n");
        printWriter.write("<meta charset=\"UTF-8\">\n");
        printWriter.write("<title>Title</title>\n");
        printWriter.write("</head>\n");
        printWriter.write("<body>\n");
        printWriter.write("这是Html1页面数据\n");
        printWriter.write(" </body>\n");
        printWriter.write("</html>\n");
    }
}
