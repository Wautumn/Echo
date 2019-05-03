package com.wang.store.dao;

import com.wang.store.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 17:36
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDaoTest {
    @Autowired
    OrderDao orderDao;

    @Test
    public void generate(){
        Order order=new Order();
        order.setUserid(1);
        order.setState(0);
        order.setSettime("aaaa");
        order.setAddressid(5);
        float a=10.10f;
        order.setPrice(a);
        orderDao.GenerateOrder(order);
    }
}
