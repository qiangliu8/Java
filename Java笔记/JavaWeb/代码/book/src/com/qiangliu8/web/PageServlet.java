package com.qiangliu8.web;

import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Page;
import com.qiangliu8.service.BookService;
import com.qiangliu8.service.impl.BookServiceImpl;
import com.qiangliu8.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class PageServlet extends BaseServlet{

    BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageno和pagesize
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.ParseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookservice.page(pageno,pagesize) Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        //保存page对象到reqyest域中
        req.setAttribute("page",page);
        //请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
