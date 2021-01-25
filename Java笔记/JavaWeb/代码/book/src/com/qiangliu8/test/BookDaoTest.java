package com.qiangliu8.test;

import com.qiangliu8.dao.BookDao;
import com.qiangliu8.dao.impl.BookDaoImpl;
import com.qiangliu8.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {
    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"剑指offer","海涛",new BigDecimal(18) ,2000,15,"static/img/turn_on_offer.png"));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBook(21);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(20,"剑指offer","海涛",new BigDecimal(28) ,999,15,"static/img/turn_on_offer.png"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(21));
    }

    @Test
    public void queryBooks() {
        for (Book queryBooks:bookDao.queryBooks()) {
            System.out.println(queryBooks);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageItems() {
        for (Book book:bookDao.queryForPageItems(3,8)) {
            System.out.println(book);
        }
    }
    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(0,1000));
    }
    @Test
    public void queryForPageItemsByPrice() {
        for (Book book:bookDao.queryForPageItemsByPrice(0,8,10,100)) {
            System.out.println(book);
        }
    }

}