package com.qiangliu8.dao;
import com.qiangliu8.pojo.Book;

import java.util.List;

public interface BookDao {
    //增加图书
    public int addBook(Book book);
    //删除图书
    public int deleteBook(Integer id);
    //修改图书
    public int updateBook(Book book);
    //通过ID查找图书
    public Book queryBookById(Integer id);
    //
    public List<Book> queryBooks();
    //查找总记录数
    Integer queryForPageTotalCount();
    //查找当前页的数据
    List<Book> queryForPageItems(int begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int begin, int pageSize, int min, int max);
    //根据价格查找记录
    // List<Book> queryForPageTotalCount()
}
