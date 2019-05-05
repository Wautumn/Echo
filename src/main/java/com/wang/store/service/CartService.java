package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.dao.CartDao;
import com.wang.store.entity.Book;
import com.wang.store.entity.Cart;
import com.wang.store.entity.util.CartInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 10:29
 */
@Service
public class CartService {
    @Autowired
    CartDao cartDao;

    @Autowired
    BookDao bookDao;

    //添加购物车
    public void AddCart(Cart cart) {
        if (cartDao.IfExistCart(cart) == null) {//不存在
            cartDao.AddBookToCart(cart);
        } else {
            cartDao.UpdateCart(cart);//存在就修改数量
        }

    }

    //从购物车中删除
    public void Delete(int id){
        cartDao.DeleteCart(id);
    }




    //获取用户的购物车信息
    public List<CartInfo> GetCartInfor(int userid) {
        List<Cart> carts = cartDao.GetCartByUserid(userid);
        List<CartInfo> cartInfos = new LinkedList<>();
        for (Cart cart : carts) {
            CartInfo cartInfo = new CartInfo();
            Book book = bookDao.FindBookById(cart.getBookid());
            cartInfo.setBook(book);
            cartInfo.setNum(cart.getNum());
            cartInfos.add(cartInfo);
        }
        return cartInfos;

    }

    public void ChangeNum(Cart cart){
        cartDao.ChangeCartNum(cart);
    }
}
