package com.wang.store.entity;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 15:37
 */
public class Order {

    private int id;

    private int userid;

    private String settime;

    private int state;//订单状态，0为未支付，1为已支付，2为已完成

    private int addressid;

    private float price;


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

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
