package com.wang.store.entity.util;

import com.wang.store.entity.Book;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 16:55
 */
public class CartInfo {
    private Book book;

    private int num;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
