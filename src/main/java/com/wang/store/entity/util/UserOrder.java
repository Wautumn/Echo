package com.wang.store.entity.util;

import com.wang.store.entity.Address;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 17:18
 */
public class UserOrder {
    private int id;

    private int userid;

    private String settime;

    private int state;//订单状态，0为未支付，1为已支付，2为已完成

    private Address address;

    private float price;

    private List<CartInfo> cartInfos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getSettime() {
        return settime;
    }

    public void setSettime(String settime) {
        this.settime = settime;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<CartInfo> getCartInfos() {
        return cartInfos;
    }

    public void setCartInfos(List<CartInfo> cartInfos) {
        this.cartInfos = cartInfos;
    }
}
