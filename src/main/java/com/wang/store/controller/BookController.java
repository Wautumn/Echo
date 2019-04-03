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
    public List<Book> GetBookByName(String name,int page){
        List books=bookService.FindBookByName(name);
        int sumpage=books.size()/8+1;
       /* System.out.println(books.subList(0,8).size());
        System.out.println(books.subList(8,14).size());*/
        List result=new LinkedList();
        if((page*8)<books.size()) {
            result.addAll(books.subList((page - 1) * 8, (page * 8)));

        }else {
            result.addAll(books.subList((page - 1) * 8, books.size() ));
            // System.out.println((books.subList((page - 1) * 8, books.size())).size());
        }
        result.add(sumpage);
        return result;
    }

    @RequestMapping(value = "/getBookByType",method = RequestMethod.GET)
    public List<Book> GetBookByType(String type,int page){
        List books=bookService.FindBookByType(type);
        System.out.println(books.size());
        int sumpage=books.size()/8+1;
       /* System.out.println(books.subList(0,8).size());
        System.out.println(books.subList(8,14).size());*/
        List result=new LinkedList();
        if((page*8)<books.size()) {
            result.addAll(books.subList((page - 1) * 8, (page * 8)));

        }else {
            result.addAll(books.subList((page - 1) * 8, books.size() ));
           // System.out.println((books.subList((page - 1) * 8, books.size())).size());
        }
        result.add(sumpage);
        return result;
    }

    @RequestMapping(value = "/getHotBooks",method = RequestMethod.GET)
    public List<Book> GetHotBooks(){
        return bookService.GetHotBook();
    }

    @RequestMapping(value = "/getDiscountBooks",method = RequestMethod.GET)
    public List GetDiscountBooks(int page){
        List<Book> alldiscountbooks=bookService.GetDiscountBook();
        int sumpage=alldiscountbooks.size()/8+1;//页数
        List results=new LinkedList();
        List<Book> discountbooks=alldiscountbooks.subList((page-1)*8,page*8);
        if((page*8)<alldiscountbooks.size()) {
            results.addAll(alldiscountbooks.subList((page - 1) * 8, (page * 8)));
            System.out.println(alldiscountbooks.subList((page - 1) * 8, (page * 8)).size());

        }else {
            results.addAll(alldiscountbooks.subList((page - 1) * 8, alldiscountbooks.size() ));
            // System.out.println((books.subList((page - 1) * 8, books.size())).size());
        }

        results.add(sumpage);
        return results;
    }

    @RequestMapping(value = "/getNewBooks",method = RequestMethod.GET)
    public List<Book> GetNewBooks(){
        return bookService.GetNewBook();
    }

    @RequestMapping(value = "/getCommonRecommendBooks",method = RequestMethod.GET)
    public List<Book> GetCommonRecommendBooks(){
        return bookService.GetCommonBook();
    }




}
