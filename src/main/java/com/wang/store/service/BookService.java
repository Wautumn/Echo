package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 20:40
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public Book FindBookById(int id){
        return bookDao.FindBookById(id);
    }

    public int IfExistFindBookByName(String name){
        List<Book> books=bookDao.FindBookByName(name);
        if(books.size()==0)
            return 0;
        else
            return 1;

    }

    public List FindBookByName(String name){
        return bookDao.FindBookByName(name);
    }

    public List FindBookByType(String type){
        return bookDao.FindBookByType(type);
    }
}
