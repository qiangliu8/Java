package com.qiangliu8.service.impl;

import com.qiangliu8.dao.BookDao;
import com.qiangliu8.dao.impl.BookDaoImpl;
import com.qiangliu8.pojo.Book;
import com.qiangliu8.pojo.Page;
import com.qiangliu8.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDaoImpl();
    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBook(Integer id) {
        bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public Page<Book> page(int pageNo, int pageSize){
        Page<Book> page = new Page<Book>();

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //求总页码数
       Integer pageTotal  = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize != 0){
            pageTotal+=1;
        }
        if (pageNo<1){
            pageNo=1;
        }else if (pageNo>pageTotal){
            pageNo =  pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

//        //求当前页数据
        int begin = (page.getPageNo() -1 ) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin,pageSize);


        //设置一页显示大小
        page.setPageSize(pageSize);
//        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
//        //设置总页码数
        page.setPageToal(pageTotal);
       //设置当前页数据
       page.setItems(items);
        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<Book>();

        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min,max);
        //求总页码数
        Integer pageTotal  = pageTotalCount / pageSize;
        if(pageTotalCount % pageSize != 0){
            pageTotal+=1;
        }
        if (pageNo<1){
            pageNo=1;
        }else if (pageNo>pageTotal){
            pageNo =  pageTotal;
        }
        //设置当前页码
        page.setPageNo(pageNo);

//        //求当前页数据
        int begin = (page.getPageNo() -1 ) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(begin,pageSize,min,max);


        //设置一页显示大小
        page.setPageSize(pageSize);
//        //设置总记录数
        page.setPageTotalCount(pageTotalCount);
//        //设置总页码数
        page.setPageToal(pageTotal);
        //设置当前页数据
        page.setItems(items);
        return page;
    }
}
