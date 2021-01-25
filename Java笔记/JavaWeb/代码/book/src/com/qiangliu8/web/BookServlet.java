package com.qiangliu8.web;

import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Page;
import com.qiangliu8.service.BookService;
import com.qiangliu8.service.impl.BookServiceImpl;
import com.qiangliu8.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;


public class BookServlet extends BaseServlet {
    BookService bookService = new BookServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求的参数==封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2.调用BookService.addBook()保存图书
        bookService.addBook(book);
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),0);
        pageNo+=1;
        //3.跳到图书列表页面--重定向解决重复提交
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);
    }
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),0);
        String id = req.getParameter("id");
        bookService.deleteBook(Integer.parseInt(id));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        bookService.updateBook(book);
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),0);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNo="+pageNo);

    }
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> bookList = bookService.queryBooks();
        req.setAttribute("bookList",bookList);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Book book = bookService.queryBookById(Integer.parseInt(id));
        req.setAttribute("book",book);
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),0);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp?pageNo="+pageNo).forward(req,resp);
    }
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数pageno和pagesize
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.ParseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookservice.page(pageno,pagesize) Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("manager/bookServlet?action=page");
        //保存page对象到reqyest域中
        req.setAttribute("page",page);
        //请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
