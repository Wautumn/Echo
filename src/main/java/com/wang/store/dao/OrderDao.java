package com.wang.store.dao;

import com.wang.store.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 15:36
 */
@Mapper
@Component
public interface OrderDao {

    void GenerateOrder(Order order);

    void ChangeOrderState(Order order);

    Order GetOrderById(int id);

    List<Order> GetOrderByUserid(int userid);
}
