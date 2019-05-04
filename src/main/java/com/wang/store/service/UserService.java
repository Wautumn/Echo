package com.wang.store.service;

import com.wang.store.dao.UserDao;
import com.wang.store.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: WHQ
 * @Date: 2019/5/4 10:36
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Autowired
    JWTService JWTService;

    public User IfExist(String name) {
        User user = userDao.IfExist(name);
        if (user != null)
            return user;
        return null;
    }

    public boolean Verify(String name,String password){
        if(IfExist(name).getPassword().equals(password))
            return true;
        return false;
    }

    public String CreateToken(String name) throws Exception{
        User user=IfExist(name);
        return JWTService.createToken(user);
    }

}
