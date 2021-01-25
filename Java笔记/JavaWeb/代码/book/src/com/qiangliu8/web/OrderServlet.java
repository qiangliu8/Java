package com.qiangliu8.web;

import com.qiangliu8.pojo.Cart;
import com.qiangliu8.pojo.User;
import com.qiangliu8.service.BookService;
import com.qiangliu8.service.OrderService;
import com.qiangliu8.service.impl.BookServiceImpl;
import com.qiangliu8.service.impl.OrderServiceImpl;
import com.qiangliu8.utils.JdbcUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends BaseServlet{
    OrderService orderService = new OrderServiceImpl();
    BookService bookService = new BookServiceImpl();
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取UserID
        User loginUser = (User) req.getSession().getAttribute("LoginUser");
        if (loginUser==null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }
        Integer userID = loginUser.getId();

        //调用orderService的createOrder生成订单

        String orderId = null;
        orderId =  orderService.createOrder(cart,userID);
//        try {
//            orderId =  orderService.createOrder(cart,userID);
//            JdbcUtils.commitAndClose();
//        }catch (Exception e){
//            JdbcUtils.rollbackAndClose();
//            e.printStackTrace();
//        }
        System.out.println("订单号"+orderId);
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }
}
