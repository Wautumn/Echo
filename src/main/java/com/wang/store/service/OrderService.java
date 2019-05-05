package com.wang.store.service;

import com.wang.store.dao.*;
import com.wang.store.entity.*;
import com.wang.store.entity.util.CartInfo;
import com.wang.store.entity.util.UserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 15:36
 */
@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    @Autowired
    OrderInfoDao orderInfoDao;

    @Autowired
    CartDao cartDao;

    @Autowired
    BookDao bookDao;

    @Autowired
    AddressDao addressDao;

    /*
    生成订单：
    订单表新增用户订单
    订单info表加入订单信息
    购物车删除相关记录
     */
    public int GnerateOrder(int userid, int[] cartsid, int addressid,float price) {
        Order order = new Order();
        Date nowTime = new Date();
        SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        order.setUserid(userid);
        order.setAddressid(addressid);
        order.setSettime(time.format(nowTime));
        order.setState(0);
       // float price = 0;
        for (int i = 0; i < cartsid.length; i++) {
            Cart fin=new Cart();
            fin.setUserid(userid);
            fin.setBookid(cartsid[i]);
            Cart cart = cartDao.GetCartIdByUserbook(fin);
            Book book = bookDao.FindBookById(cart.getBookid());
          //  price += Float.parseFloat(book.getNowprice())*cart.getNum();
        }

        System.out.println(price);
        order.setPrice(price);
        orderDao.GenerateOrder(order);


        for (int i = 0; i < cartsid.length; i++) {
            Cart fin=new Cart();
            fin.setUserid(userid);
            fin.setBookid(cartsid[i]);
            Cart cart = cartDao.GetCartIdByUserbook(fin);
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setBookid(cart.getBookid());
            orderInfo.setNum(cart.getNum());
            orderInfo.setOrderid(order.getId());
            orderInfoDao.AddOrderInfo(orderInfo);
            cartDao.DeleteCart(cart.getId());//删除购物车的信息

        }
        return order.getId();
    }


    public List<UserOrder> GetOrdersByUser(int userid) {
        List<UserOrder> userOrders = new LinkedList<>();
        List<Order> orders = orderDao.GetOrderByUserid(userid);
        for (Order order : orders) {
            UserOrder userOrder = new UserOrder();
            int orderid = order.getId();

            userOrder.setId(orderid);
            userOrder.setUserid(order.getUserid());
            userOrder.setSettime(order.getSettime());
            userOrder.setState(order.getState());
            userOrder.setAddress(addressDao.GetAddressById(order.getAddressid()));
            userOrder.setPrice(order.getPrice());

            List<OrderInfo> orderInfos = orderInfoDao.GetInfoByOrderId(orderid);
            List<CartInfo> cartInfos = new LinkedList<>();
            for (OrderInfo orderInfo : orderInfos) {
                CartInfo cartInfo = new CartInfo();
                cartInfo.setNum(orderInfo.getNum());
                cartInfo.setBook(bookDao.FindBookById(orderInfo.getBookid()));
                cartInfos.add(cartInfo);
            }
            userOrder.setCartInfos(cartInfos);
            userOrders.add(userOrder);


        }
        return userOrders;

    }

    public UserOrder GetUserOrderById(int id) {
        Order order = orderDao.GetOrderById(id);
        UserOrder userOrder = new UserOrder();
        int orderid = order.getId();

        userOrder.setId(orderid);
        userOrder.setUserid(order.getUserid());
        userOrder.setSettime(order.getSettime());
        userOrder.setState(order.getState());
        userOrder.setAddress(addressDao.GetAddressById(order.getAddressid()));
        userOrder.setPrice(order.getPrice());

        List<OrderInfo> orderInfos = orderInfoDao.GetInfoByOrderId(orderid);
        List<CartInfo> cartInfos = new LinkedList<>();
        for (OrderInfo orderInfo : orderInfos) {
            CartInfo cartInfo = new CartInfo();
            cartInfo.setNum(orderInfo.getNum());
            cartInfo.setBook(bookDao.FindBookById(orderInfo.getBookid()));
            cartInfos.add(cartInfo);
        }
        userOrder.setCartInfos(cartInfos);
        return userOrder;

    }


}
