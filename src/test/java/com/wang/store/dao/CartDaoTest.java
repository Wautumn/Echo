package com.wang.store.dao;

import com.wang.store.entity.Cart;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 10:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CartDaoTest {
    @Autowired
    CartDao cartDao;

    @Test
    public void add() {
        Cart cart = new Cart();
        cart.setBookid(1);
        cart.setUserid(1);
        cart.setNum(1);
        cartDao.AddBookToCart(cart);
        System.out.println(cart.getId());
    }

    @Test
    public void getcart() {
        List<Cart> list = cartDao.GetCartByUserid(1);
        for (Cart cart : list) {
            System.out.println(cart.getId());
        }
    }

    @Test
    public void ifexist() {
        Cart cart = new Cart();
        cart.setBookid(5);
        cart.setUserid(1);
        if (cartDao.IfExistCart(cart) == null) {
            System.out.println("null");
        } else {
            System.out.println("exist");
        }
    }

    @Test
    public void update() {
        Cart cart = new Cart();
        cart.setBookid(1);
        cart.setUserid(1);
        cart.setNum(2);
        cartDao.UpdateCart(cart);
    }
}
