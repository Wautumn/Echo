package com.wang.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 10:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartServiceTest {
    @Autowired
    CartService cartService;

    @Test
    public void getCartByUser(){
        List<CartService.CartInfo> list=cartService.GetCartInfor(1);
        System.out.println(list.size());
        for(CartService.CartInfo cartInfo:list){
            System.out.println(cartInfo.getBook().getName());
        }
    }
}
