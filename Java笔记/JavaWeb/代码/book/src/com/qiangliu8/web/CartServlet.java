package com.qiangliu8.web;

import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Cart;
import com.qiangliu8.pojo.CartItem;
import com.qiangliu8.service.BookService;
import com.qiangliu8.service.impl.BookServiceImpl;
import com.qiangliu8.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

public class CartServlet extends BaseServlet{
    BookService bookService = new BookServiceImpl();
    //加入购物车
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数商品编号
        int id= WebUtils.ParseInt(req.getParameter("id"),0);
        //调用bookservice.queryBookByid(id ) : Book得到图书的信息
        Book book = bookService.queryBookById(id);
        //把图书信息，转换成为Cartitem商品项
        CartItem cartItem = new CartItem(book.getId(),book.getName(), 1,book.getPrice(),book.getPrice());
        //数据回显
        req.getSession().setAttribute("lastName",book.getName());
        //判断是否有购物车
        Cart cart = (Cart) req.getSession().getAttribute("cart");

        if (cart==null){

            cart = new Cart();

            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        System.out.println("《"+book.getName()+"》放入了购物车");
        System.out.println(cart);

        //页面跳转
        String Referer = req.getHeader("Referer");
        resp.sendRedirect(Referer);
    }

    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数商品编号
        int id = WebUtils.ParseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.deleteItem(id);
            System.out.println("删除成功！");
        }
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }

    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.clear();
            System.out.println("清空购物车成功！");
        }
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }
    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.ParseInt(req.getParameter("id"),0);
        int count = WebUtils.ParseInt(req.getParameter("count"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (cart!=null){
            cart.updateCount(id,count);
            System.out.println("修改数据成功！");
        }
        String referer = req.getHeader("Referer");
        resp.sendRedirect(referer);
    }

}
