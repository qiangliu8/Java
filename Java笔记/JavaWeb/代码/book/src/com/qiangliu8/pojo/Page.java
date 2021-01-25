package com.qiangliu8.pojo;

import java.util.List;

public class Page<T> {

    public static final Integer PAGE_SIZE = 4;
    //当前页码
    private Integer pageNo;
    //总页码
    private Integer pageToal;
    //当前页显示数量
    private Integer pageSize = PAGE_SIZE;
    //总记录数
    private Integer pageTotalCount;
    //当前页数据
    private List<T> items;
    //分页条请求地址
    private String url;
    public Page() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageToal=" + pageToal +
                ", pageSize=" + pageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }

    public Page(Integer pageNo, Integer pageToal, Integer pageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageToal = pageToal;
        this.pageSize = pageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public static Integer getPageSize() {
        return PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return (List<T>) items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageToal() {
        return pageToal;
    }

    public void setPageToal(Integer pageToal) {
        this.pageToal = pageToal;
    }
}
