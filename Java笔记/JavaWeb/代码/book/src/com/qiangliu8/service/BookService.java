package com.qiangliu8.service;

import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Page;

import java.util.List;

public interface BookService {

    //增加图书
    public void addBook(Book book);
    //删除图书
    public void deleteBook(Integer id);
    //修改图书
    public void updateBook(Book book);
    //通过ID查找图书
    public Book queryBookById(Integer id);
    //
    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max);
}
