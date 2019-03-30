package com.wang.store.dao;

import com.wang.store.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 20:33
 */
@Mapper
@Component
public interface BookDao {

    Book FindBookById(int id);

    List<Book> GetAllBook();

    List<Book> FindBookByName(String name);

    List<Book> FindBookByType(String type);

    List<Book> GetHotBook();

    List<Book> GetDiscountBook();

    void InsertBook(Book book);

    void UpdateBookStock(int id,int stock);

    void UpdateBookPrePrice(int id);

    void UpdateBookPrice(int id,int price);

    int InsertAndGetId(Book book);





}
