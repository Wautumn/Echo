package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.entity.Book;
import org.jsoup.Jsoup;
import org.junit.Test;
import org.jsoup.nodes.Document;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;


/**
 * @Author: WHQ
 * @Date: 2019/3/25 21:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GetInforTest {
    @Autowired
    InformationService informationService;

    @Autowired
    BookDao bookDao;

    @Autowired
    AdminService adminService;

    @Test
    public void GetInformation(){
       try {

          informationService.GetDetail("s","https://book.douban.com/subject/5275059/");

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Test
    public void GetType(){
        //跑过了40和20
        informationService.GetType("小说");
        informationService.GetType("外国文学");
        informationService.GetType("文学");
        informationService.GetType("随笔");
        informationService.GetType("经典");
        informationService.GetType("散文");
        informationService.GetType("诗歌");
        informationService.GetType("童话");
        informationService.GetType("杂文");
        informationService.GetType("古典文学");


        informationService.GetType("漫画");
        informationService.GetType("推理");
        informationService.GetType("青春");
        informationService.GetType("科幻");
        informationService.GetType("悬疑");
      /*  informationService.GetType("言情");
        informationService.GetType("武侠");
        informationService.GetType("魔幻");
        informationService.GetType("奇幻");
        informationService.GetType("穿越");*/
/*

        informationService.GetType("历史");
        informationService.GetType("心理学");
        informationService.GetType("哲学");
        informationService.GetType("传记");
        informationService.GetType("文化");
        informationService.GetType("艺术");
        informationService.GetType("社会");
        informationService.GetType("政治");
        informationService.GetType("宗教");
        informationService.GetType("数学");
        informationService.GetType("思想");
        informationService.GetType("国学");
        informationService.GetType("人文");
        informationService.GetType("音乐");
        informationService.GetType("绘画");
        informationService.GetType("戏剧");
        informationService.GetType("近代史");
        informationService.GetType("军事");
        informationService.GetType("佛教");
        informationService.GetType("考古");
*/

/*
        informationService.GetType("爱情");
        informationService.GetType("成长");
        informationService.GetType("旅行");
        informationService.GetType("生活");
        informationService.GetType("心理");
        informationService.GetType("励志");
        informationService.GetType("女性");
        informationService.GetType("教育");
        informationService.GetType("美食");
        informationService.GetType("养生");

        informationService.GetType("商业");
        informationService.GetType("金融");
        informationService.GetType("投资");
        informationService.GetType("营销");
        informationService.GetType("创业");
        informationService.GetType("广告");
        informationService.GetType("互联网");
        informationService.GetType("编程");
        informationService.GetType("科学");
        informationService.GetType("算法");*/




    }

    @Test
    public void changesales(){
        List<Book> books=bookDao.GetAllBook();
        int num=books.size();
        Random random=new Random();
        for(int i=0;i<num;i++) {

            bookDao.UpdateMonthsales(books.get(i).getId(),random.nextInt(1000));
        }
    }

    @Test
    public void changeprice(){
        List<Book> books=bookDao.GetAllBook();
        int num=books.size();
        Random random=new Random();
        for(int i=0;i<num;i++) {
            DecimalFormat df = new DecimalFormat("#0.00");
            Double min=10.0;
            Double max=50.0;

            String price=df.format(min + ((max - min) * random.nextDouble()));
           // System.out.println(price);
            adminService.UpdateBookPrice(books.get(i).getId(),price);

        }
    }


}
