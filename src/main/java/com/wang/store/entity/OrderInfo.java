package com.wang.store.entity;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 15:32
 * 记录订单中的信息
 */

public class OrderInfo {
    private int id;

    private int bookid;

    private int num;

    private int orderid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
