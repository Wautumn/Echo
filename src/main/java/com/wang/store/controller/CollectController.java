package com.wang.store.controller;

import com.alibaba.fastjson.JSONObject;
import com.wang.store.entity.Book;
import com.wang.store.entity.Collect;
import com.wang.store.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 20:11
 */
@RestController
public class CollectController {
    @Autowired
    CollectService collectService;

    @RequestMapping(value = "/addCollect", method = RequestMethod.POST)
    public int AddCollect(@RequestBody JSONObject jsonObject) {
        int userid = Integer.parseInt(jsonObject.get("userid").toString());
        int bookid = Integer.parseInt(jsonObject.get("bookid").toString());
        Collect collect = new Collect();
        collect.setBookid(bookid);
        collect.setUserid(userid);

        return collectService.AddCollect(collect);
    }

    @RequestMapping(value = "/deleteCollect", method = RequestMethod.GET)
    public String DeleteCollect(int id) {
        collectService.DeleteCollect(id);
        return "success";
    }

    @RequestMapping(value = "/getCollectByUser",method = RequestMethod.GET)
    public List<Book> GetCollectByUser(int userid){
       return collectService.GetCollectByUser(userid);
    }
}
