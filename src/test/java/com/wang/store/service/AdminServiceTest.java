package com.wang.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WHQ
 * @Date: 2019/4/3 20:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {
    @Autowired
    AdminService adminService;

    @Test
    public void UpdateStock(){
        adminService.UpdateBookStock(1,400);
    }

    @Test
    public void UpdatePrice(){
        adminService.UpdateBookPrice(1,400);
    }
}
