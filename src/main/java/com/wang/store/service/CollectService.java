package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.dao.CollectDao;
import com.wang.store.entity.Book;
import com.wang.store.entity.Collect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: WHQ
 * @Date: 2019/5/3 20:07
 */
@Service
public class CollectService {
    @Autowired
    CollectDao collectDao;

    @Autowired
    BookDao bookDao;

    public Collect GetCollect(int userid,int bookid){
        Collect collect=new Collect();
        collect.setUserid(userid);
        collect.setBookid(bookid);
        return collectDao.IfCollected(collect);
    }

    public int IfCollected(Collect collect){
        if(collectDao.IfCollected(collect)!=null)
            return 1;//存在
        return 0;
    }

    public int AddCollect(Collect collect){
        System.out.println(IfCollected(collect));
        if(IfCollected(collect)==1) return -1;//已存在
        collectDao.AddCollect(collect);
        return collect.getId();
    }

    public void DeleteCollect(int id){
        collectDao.DeleteCollect(id);

    }

    public List<Book> GetCollectByUser(int userid){
       List<Collect> collects=collectDao.GetCollectsByUser(userid);
       List<Book> books=new LinkedList<>();

       for (Collect collect:collects){
           Book book=bookDao.FindBookById(collect.getBookid());
           books.add(book);
       }

       return books;
    }
}
