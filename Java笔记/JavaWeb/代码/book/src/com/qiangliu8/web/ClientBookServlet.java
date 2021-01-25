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

public class ClientBookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("");
        //获取请求的参数pageno和pagesize
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.ParseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //调用bookservice.page(pageno,pagesize) Page对象
        Page<Book> page = bookService.page(pageNo,pageSize);
        page.setUrl("client/ClientBookServlet?action=page");
        //保存page对象到reqyest域中
        req.setAttribute("page",page);
        System.out.println("这是前台Servlet"+page);
        //请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }
    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取请求的参数pageno和pagesize
        int pageNo = WebUtils.ParseInt(req.getParameter("pageNo"),1);
        int pageSize = WebUtils.ParseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.ParseInt(req.getParameter("min"),0);
        int max = WebUtils.ParseInt(req.getParameter("max"),10);
        //调用bookservice.page(pageno,pagesize) Page对象
        Page<Book> page = bookService.pageByPrice(pageNo,pageSize,min,max);

        StringBuilder stringBuilder = new StringBuilder("client/ClientBookServlet?action=pageByPrice");
        if (req.getParameter("min")!=null){
            stringBuilder.append("&min=").append(req.getParameter("min"));
        }
        if (req.getParameter("max")!=null){
            stringBuilder.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(stringBuilder.toString());
        //保存page对象到reqyest域中
        req.setAttribute("page",page);
        System.out.println(page);
        //请求转发到/pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
