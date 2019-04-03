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

        //   informationService.GetDetail();

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Test
    public void GetType(){
        informationService.GetType("小说");

        informationService.GetType("散文");
        informationService.GetType("文学");
        informationService.GetType("诗歌");
        informationService.GetType("经典");

        informationService.GetType("青春");
        informationService.GetType("言情");
        informationService.GetType("武侠");
        informationService.GetType("奇幻");
        informationService.GetType("校园");

        informationService.GetType("历史");
        informationService.GetType("哲学");
        informationService.GetType("艺术");
        informationService.GetType("政治");
        informationService.GetType("社会");

        informationService.GetType("成长");
        informationService.GetType("励志");
        informationService.GetType("生活");
        informationService.GetType("游记");
        informationService.GetType("健康");

        informationService.GetType("悬疑");
        informationService.GetType("思想");




    }


}
