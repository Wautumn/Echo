package com.wang.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 17:20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    OrderService orderService;

    @Test
    public void generate(){
        int[] carts=new int[2];
        carts[0]=1;
        carts[1]=2;
        orderService.GnerateOrder(1,carts,2,10);
    }
}
