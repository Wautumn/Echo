package com.wang.store.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.util.UserOrder;
import com.wang.store.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 15:35
 */
@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

    /*
    订单生成的逻辑：
    传入cartid数组，即购物车选中的项
    传入userid  addressid

    后端逻辑：
    插入订单表新记录，
    对此新记录的id，在订单和购物车的关系表中，插入订单id和购物车信息id
    将购物车中的相应记录删除
     */
    @RequestMapping(value = "/generateOrder",method = RequestMethod.POST)
    public int GenerateOrder(@RequestBody JSONObject jsonObject){
        JSONArray carts=jsonObject.getJSONArray("carts");
        int[] array=new int[carts.size()];
        for(int i=0;i<carts.size();i++){
            array[i]=Integer.parseInt(carts.get(i).toString());
        }
        int userid=Integer.parseInt(jsonObject.get("userid").toString());
        int addressid=Integer.parseInt(jsonObject.get("addressid").toString());
        int id=orderService.GnerateOrder(userid,array,addressid);
        return id;

    }

    @RequestMapping(value = "/getOrders",method = RequestMethod.GET)
    public List<UserOrder> GetUserOrders(int userid){
        return orderService.GetOrdersByUser(userid);
    }

    @RequestMapping(value = "/getUserOneOrder",method = RequestMethod.GET)
    public UserOrder GetUserOneOrder(int id){
        return orderService.GetUserOrderById(id);
    }


}
