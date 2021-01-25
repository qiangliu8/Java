package com.qiangliu8.test;

import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Page;
import com.qiangliu8.service.BookService;
import com.qiangliu8.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    private  BookService bookService = new BookServiceImpl();
    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"深入理解JVM虚拟机","俞文竹",new BigDecimal(66) ,1000,150,"static/img/JVM.png"));
    }

    @Test
    public void deleteBook() {
        bookService.deleteBook(42);
    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(19,"剑指offer","海涛1",new BigDecimal(28) ,999,15,"static/img/turn_on_offer.png"));

    }

    @Test
    public void queryBookById() {
        System.out.println(bookService.queryBookById(43));
    }

    @Test
    public void queryBooks() {
        for (Book queryBooks:bookService.queryBooks()) {
            System.out.println(queryBooks);
        }
    }
    @Test
    public void page(){
        System.out.println(bookService.page(1,Page.PAGE_SIZE));
    }
    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(1,Page.PAGE_SIZE,9,10));
    }
}