package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.Book;
import com.wang.store.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: WHQ
 * @Date: 2019/4/3 20:11
 */
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/insertBook",method = RequestMethod.POST)
    public int InsertBook(@RequestBody JSONObject jsonObject){
        Book book=new Book();
        String name=jsonObject.get("name").toString();
        String author=jsonObject.get("author").toString();
        String picture=jsonObject.get("picture").toString();
        String type=jsonObject.get("type").toString();
        String introduction=jsonObject.get("introduction").toString();
        String price=jsonObject.get("price").toString();
        int stock=Integer.parseInt(jsonObject.get("stock").toString());
        String subtitle=jsonObject.get("subtitle").toString();
        String page=(jsonObject.get("page").toString());
        String press=jsonObject.get("press").toString();
        String presstime=jsonObject.get("presstime").toString();
        String isbn=jsonObject.get("isbn").toString();
        String authorcontent=jsonObject.get("authorcontent").toString();
        String catelog=jsonObject.get("catelog").toString();

        book.setName(name);
        book.setAuthor(author);
        book.setPicture(picture);
        book.setType(type);
        book.setIntroduction(introduction);
        book.setNowprice(price);
        book.setPreprice(price);
        book.setAuthor(author);
        book.setStock(stock);
        book.setSubtitle(subtitle);
        book.setPage(page);
        book.setPress(press);
        book.setPresstime(presstime);
        book.setIsbn(isbn);
        book.setAuthorcontent(authorcontent);
        book.setCatelog(catelog);

        return adminService.InsertAndGetId(book);

    }

    @RequestMapping(value = "/changeStock",method = RequestMethod.GET)
    public String ChangeStock(int id,int stock){
        adminService.UpdateBookStock(id,stock);
        return "success";
    }

    @RequestMapping(value = "/changePrice",method = RequestMethod.GET)
    public String ChangePrice(int id,int price){
        adminService.UpdateBookPrice(id,price);
        return "success";
    }


}
