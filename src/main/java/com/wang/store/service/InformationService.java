package com.wang.store.service;

import com.wang.store.entity.Book;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @Author: WHQ
 * @Date: 2019/3/25 21:07
 */
@Service
public class InformationService {
    @Autowired
    AdminService adminService;

    private String type;

    public void GetType(String type) {
        this.type = type;
        try {
            Document document = Jsoup.connect("https://book.douban.com/tag/" + type+"?start=20&type=T").get();
            Elements linkelements = document.select("#subject_list").select("ul").select("li");
            System.out.println(linkelements.size());
            for (int i = 0; i < linkelements.size(); i++) {
               // System.out.println(linkelements.get(i).text());
                String url = linkelements.get(i).select(".info").select("h2").select("a").attr("href");
                GetDetail(type,url);
            }

        } catch (Exception e) {

        }

    }

    public void GetDetail(String type,String url) {
        Book book = new Book();
        try {
            String regEx="[^0-9]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(url);

            String number=m.replaceAll("").trim();
            System.out.println(number);

            Document doc = Jsoup.connect(url).get();

            //书名
            String name = doc.select("#wrapper").select("h1").select("span").text();
           // System.out.println(name);

            //图片
            String pic = doc.select("#mainpic").select("a").attr("href");
          //  System.out.println(pic);

            //书籍信息
            String detail = doc.select("#info").text();
          //  System.out.println(detail);

            String[] infor = detail.split(" ");


            String author = doc.select("#info").select("a").first().text();
            String press = "";
            String subtitle = "";
            String presstime = "";
            String page = "";
            String price = "";
            String isbn = "";

            for (int i = 0; i < infor.length; i++) {
                if (infor[i].matches(".*作者:*."))
                  //  author = infor[i + 1];
                if (infor[i].matches(".*出版社:*."))
                    press = infor[i + 1];
                if (infor[i].matches(".*副标题:*."))
                    subtitle = infor[i + 1];
                if (infor[i].matches(".*出版年:*."))
                    presstime = infor[i + 1];
                if (infor[i].matches(".*页数:*."))
                    page = infor[i + 1];
                if (infor[i].matches(".*定价*."))
                    price = infor[i + 1];
                if (infor[i].matches(".*ISBN*."))
                    isbn = infor[i + 1];

            }


            //content 内容简介
            String content = doc.select(".intro").get(0).select("p").text();
            //System.out.println(content);


            //作者简介
            Elements elements= doc.select(".intro");
            String authorintroduction="";
            if(elements.size()>2) {
                authorintroduction = doc.select(".intro").get(2).select("p").text();
               // System.out.println(authorintroduction);
            }

            //目录indent
            String catelog="";
            if(doc.select("#dir_"+number+"_full")!=null) {
                catelog = doc.select("#dir_"+number+"_full").text();
                //System.out.println(catelog);
            }


            book.setName(name);
            book.setPicture(pic.replace("https"," https://images.weserv.nl/?url=https"));
            book.setAuthor(author);
            book.setType(type);
            book.setIntroduction(content);
            book.setPreprice(price.replace("元",""));
            book.setNowprice(price.replace("元",""));
            book.setStock(100);
            book.setMonthsales(50);
            book.setSubtitle(subtitle);
            book.setPage(page);
            book.setPress(press);
            book.setPresstime(presstime);
            book.setIsbn(isbn);
            book.setAuthorcontent(authorintroduction);
            book.setCatelog(catelog);

        } catch (Exception e) {
            e.printStackTrace();
        }



        adminService.InsertBook(book);

    }
}
