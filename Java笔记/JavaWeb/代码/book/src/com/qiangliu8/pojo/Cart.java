package com.qiangliu8.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    //private Integer totalCount;
    //private BigDecimal totalPrice;
    /*
    key 是商品  value 是商品信息
    **/
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();

    public Cart() {
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }


    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer,CartItem>entry: items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

//    public void setTotalCount(Integer totalCount) {
//
//        this.totalCount = totalCount;
//    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer,CartItem>entry: items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;
    }

//    public void setTotalPrice(BigDecimal totalPrice) {
//        this.totalPrice = totalPrice;
//    }

    public Cart( BigDecimal totalPrice, Map<Integer, CartItem> items) {
//        this.totalCount = totalCount;
        //this.totalPrice = totalPrice;
        this.items = items;
    }

    //添加商品
    public  void addItem(CartItem cartItem){
        //先查看购物车是否添加过此商品
        CartItem item = items.get(cartItem.getId());

        if (item == null){
            //之前没添加过此商品
            items.put(cartItem.getId(),cartItem);
        }else{
            //之前添加过此商品
            //更新商品数量
            item.setCount(item.getCount()+cartItem.getCount());
            //更新金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
    //修改商品数量
    public void updateCount(Integer id, Integer count){
        CartItem item = items.get(id);

        if (item!=null){
            item.setCount(count);
            //更新总金额
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));
        }
    }
    //删除商品
    public void deleteItem(Integer id){
        items.remove(id);
    }
    //清空购物车
    public void clear(){
        items.clear();
    }
}
