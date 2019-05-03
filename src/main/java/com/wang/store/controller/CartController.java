package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.Cart;
import com.wang.store.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 11:02
 */
@RestController
public class CartController {
    @Autowired
    CartService cartService;

    //添加购物车
    @RequestMapping(value = "/addBookToCart",method = RequestMethod.POST)
    public String AddBookToCart(@RequestBody JSONObject jsonObject){
        int userid=Integer.parseInt(jsonObject.get("userid").toString());
        int bookid=Integer.parseInt(jsonObject.get("bookid").toString());
        int num=Integer.parseInt(jsonObject.get("num").toString());
        Cart cart=new Cart();
        cart.setUserid(userid);
        cart.setBookid(bookid);
        cart.setNum(num);
        cartService.AddCart(cart);
        return "success";
    }

    //获取某个用户的所有购物车信息
    @RequestMapping(value = "/getCartInfo",method = RequestMethod.GET)
    public List GetCartInfoByUser(int userid){
        return cartService.GetCartInfor(userid);
    }

}
