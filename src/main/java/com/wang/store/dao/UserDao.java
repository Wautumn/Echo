package com.wang.store.dao;

import com.wang.store.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 19:58
 */
@Mapper
@Component
public interface UserDao {

    User IfExist(String name);


}
