package com.wang.store.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: WHQ
 * @Date: 2019/3/26 10:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {
    @Autowired
    BookService bookService;

    @Test
    public void UpdateStock(){
        bookService.UpdateBookStock(1,400);
    }

    @Test
    public void UpdatePrice(){
        bookService.UpdateBookPrice(1,400);
    }

    @Test
    public void GetHotBook(){
        bookService.GetHotBook();
    }

    @Test
    public void GetDiscountBook(){
        bookService.GetDiscountBook();
    }


}
