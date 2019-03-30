package com.wang.store.service;

import com.wang.store.entity.Book;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * @Author: WHQ
 * @Date: 2019/3/25 21:07
 */
@Service
public class InformationService {
    @Autowired
    BookService bookService;

    private String type;

    public void GetType(String type){
        this.type=type;
        try {
            Document document=Jsoup.connect("https://book.douban.com/tag/"+type).get();
            Elements linkelements=document.select("#subject_list").select("ul").select("li");
            System.out.println(linkelements.size());
            for(int i=0;i<linkelements.size();i++){
                String url=linkelements.get(i).select("h2").select("a").attr("href");
                GetDetail(Jsoup.connect(url).get());
            }


        }catch (Exception e){

        }

    }

    public void GetDetail(Document doc) {
        Book book = new Book();
        try {
         //   Document doc = Jsoup.connect("https://book.douban.com/subject/1873231/").get();
            //书名
            String name = doc.select("#wrapper").select("h1").select("span").text();
            System.out.println(name);

            //图片
            String pic = doc.select("#mainpic").select("a").select("img").attr("src");
            String pic2=pic.replace("https:","https://images.weserv.nl/?url=https:");
            System.out.println(pic2);
            //https://img3.doubanio.com/view/subject/l/public/s29960161.jpg
            //https://images.weserv.nl/?url=https://img3.doubanio.com/view/subject/l/public/s28668834.jpg


            //作者
            String author = doc.select("#info").select("a").first().text();
            System.out.println(author);

            //简介
            String introduction = doc.select(".intro").select("p").first().text();
            System.out.println(introduction);

            //价格
            //String  price=doc.select("#info").select("span").get(5)text();
           // System.out.println(price);

            book.setName(name);
            book.setIntroduction(introduction);
            book.setAuthor(author);
            book.setPicture(pic2);
            book.setPreprice(100);
            book.setNowprice(100);
            book.setMonthsales(100);
            book.setType(type);

        } catch (Exception e) {
            e.printStackTrace();

        }
        bookService.InsertBook(book);

    }
}
