package com.qiangliu8.serlvet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class studentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<student> studentList = new ArrayList<student>();
        for (int i = 0; i <10 ; i++) {
            studentList.add(new student(i+1,"刘强"+i,18+i,"1877"+i));
        }
        req.setAttribute("stulist",studentList);
        req.getRequestDispatcher("/test/2.jsp").forward(req,resp);
    }
}
