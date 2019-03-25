package com.wang.store.service;

import org.jsoup.Jsoup;
import org.junit.Test;
import org.jsoup.nodes.Document;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;



/**
 * @Author: WHQ
 * @Date: 2019/3/25 21:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetInforTest {
    @Autowired
    InformationService informationService;

    @Test
    public void GetInformation(){
       try {
           Document document = Jsoup.connect("https://book.douban.com/subject/4913064/").get();
           informationService.GetDetail(document);

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Test
    public void GetType(){
        informationService.GetType("武侠");
    }


}
