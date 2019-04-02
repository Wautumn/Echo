package com.wang.store.entity;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 15:37
 */
public class Book {

    private int id;
    private String name;
    private String author;
    private String picture;
    private String type;
    private String introduction;
    private String preprice;
    private String nowprice;
    private int stock;
    private int monthsales;
    private String subtitle;
    private String page;
    private String press;
    private String presstime;
    private String isbn;
    private String authorcontent;
    private String catelog;


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

    public String getPreprice() {
        return preprice;
    }

    public void setPreprice(String preprice) {
        this.preprice = preprice;
    }

    public String getNowprice() {
        return nowprice;
    }

    public void setNowprice(String nowprice) {
        this.nowprice = nowprice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMonthsales() {
        return monthsales;
    }

    public void setMonthsales(int monthsales) {
        this.monthsales = monthsales;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPresstime() {
        return presstime;
    }

    public void setPresstime(String presstime) {
        this.presstime = presstime;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthorcontent() {
        return authorcontent;
    }

    public void setAuthorcontent(String authorcontent) {
        this.authorcontent = authorcontent;
    }

    public String getCatelog() {
        return catelog;
    }

    public void setCatelog(String catelog) {
        this.catelog = catelog;
    }
}
