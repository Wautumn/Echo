package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.Book;
import com.wang.store.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(value = "/insertBook",method = RequestMethod.POST)
    public int InsertBook(@RequestBody JSONObject jsonObject){
        Book book=new Book();
        String name=jsonObject.get("name").toString();
        String type=jsonObject.get("type").toString();
        String picture=jsonObject.get("picture").toString();
        String introduction=jsonObject.get("introduction").toString();
        String author=jsonObject.get("author").toString();
        int price=(int)Integer.parseInt(jsonObject.get("price").toString());
        int stock=(int)Integer.parseInt(jsonObject.get("stock").toString());
        book.setName(name);
        book.setType(type);
        book.setPicture(picture);
        book.setIntroduction(introduction);
        book.setAuthor(author);
        book.setNowprice(price);
        book.setPreprice(price);
        book.setStock(stock);

        bookService.InsertBook(book);
        return 1;

    }
}
