package com.wang.store.controller;

import com.wang.store.entity.Book;
import com.wang.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 20:43
 */
@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/getBookById",method = RequestMethod.GET)
    public Book GetBookById(int id){
        return bookService.FindBookById(id);
    }

    @RequestMapping(value = "/getBookByName",method = RequestMethod.GET)
    public List<Book> GetBookByName(String name){
        List<Book> books=new LinkedList<>();
        books= bookService.FindBookByName(name);
        return books;
    }

    @RequestMapping(value = "/getBookByType",method = RequestMethod.GET)
    public List<Book> GetBookByType(String type){
        return bookService.FindBookByType(type);
    }
}
