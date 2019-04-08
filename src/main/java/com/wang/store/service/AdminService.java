package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WHQ
 * @Date: 2019/4/3 20:10
 */
@Service
public class AdminService {

    @Autowired
    BookDao bookDao;

    public void InsertBook(Book book){
        bookDao.InsertBook(book);
    }

    public int InsertAndGetId(Book book){
        bookDao.InsertAndGetId(book);
        return book.getId();
    }

    public void UpdateBookStock(int id,int stock){
        bookDao.UpdateBookStock(id,stock);
    }

    public void UpdateBookPrice(int id,String price){
        bookDao.UpdateBookPrePrice(id);
        bookDao.UpdateBookPrice(id,price);
    }
}
