package com.wang.store.dao;

import com.wang.store.entity.OrderInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 16:07
 */
@Mapper
@Component
public interface OrderInfoDao {
    void AddOrderInfo(OrderInfo orderInfo);

    List<OrderInfo> GetInfoByOrderId(int orderid);
}
