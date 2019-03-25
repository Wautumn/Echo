package com.wang.store.entity;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 15:37
 */
public class Book {



    private int id;

    private String name;

    private String type;

    private String picture;

    private String introduction;

    private String author;

    private int preprice;

    private int nowprice;

    private int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPreprice() {
        return preprice;
    }

    public void setPreprice(int preprice) {
        this.preprice = preprice;
    }

    public int getNowprice() {
        return nowprice;
    }

    public void setNowprice(int nowprice) {
        this.nowprice = nowprice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


}
