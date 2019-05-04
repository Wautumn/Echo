package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.User;
import com.wang.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WHQ
 * @Date: 2019/5/4 10:46
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map verify(@RequestBody JSONObject jsonObject) throws Exception {
        String name=jsonObject.get("name").toString();
        String password =jsonObject.get("password").toString();

        Map<String, Object> map = new HashMap<String, Object>();
        User user = userService.IfExist(name);
        if(user==null){
            map.put("message", "不存在此用户");

        }else if(userService.Verify(name, password) == false){
            map.put("message", "密码错误");

        }
        else {
            map.put("message", "登录成功");
            map.put("username", user.getName());
            map.put("userid", user.getId());
            map.put("email", user.getEmail());
            map.put("phone", user.getPhone());
            map.put("token",userService.CreateToken(user.getName()));

        }
        return map;
    }
}
