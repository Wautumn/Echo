package com.wang.store.dao;

import com.wang.store.entity.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 10:13
 */
@Mapper
@Component
public interface CartDao {

    void AddBookToCart(Cart cart);

    List<Cart> GetCartByUserid(int userid);

    Cart IfExistCart(Cart cart);//当前用户购物车是否已经存在此书

    void UpdateCart(Cart cart);//修改购物车商品数量

    void CleanCart(int userid);

    void DeleteBookInCart(int bookid);
}
