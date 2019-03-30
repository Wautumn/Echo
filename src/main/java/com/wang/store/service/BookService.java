package com.wang.store.service;

import com.wang.store.dao.BookDao;
import com.wang.store.entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: WHQ
 * @Date: 2019/3/24 20:40
 */
@Service
public class BookService {

    @Autowired
    BookDao bookDao;

    public Book FindBookById(int id){
        return bookDao.FindBookById(id);
    }

    public int IfExistFindBookByName(String name){
        List<Book> books=bookDao.FindBookByName(name);
        if(books.size()==0)
            return 0;
        else
            return 1;

    }

    public List FindBookByName(String name){
        return bookDao.FindBookByName(name);
    }

    public List FindBookByType(String type){
        return bookDao.FindBookByType(type);
    }

    public static Comparator<Book> SaleComparator = new Comparator<Book>(){
        @Override
        public int compare(Book c1, Book c2) {
            return (int) (c2.getMonthsales() - c1.getMonthsales());
        }
    };

    public List<Book> GetHotBook(){
        List<Book> books=bookDao.GetHotBook();
       // System.out.println(books.size());
        Queue<Book> customerPriorityQueue = new PriorityQueue<Book>(books.size(), SaleComparator);
        for(int i=0;i<books.size();i++){
           customerPriorityQueue.add(books.get(i));
        }
        List<Book> resultbooks=new LinkedList<>();

        //默认队列大小大于10
        for(int i=0;i<10;i++){
            resultbooks.add(customerPriorityQueue.remove());
        }
        return resultbooks;

    }

    public static Comparator<Book> DiscountComparator = new Comparator<Book>(){
        @Override
        public int compare(Book c1, Book c2) {
            return (int) (DiscountDegree(c1) - DiscountDegree(c2));
        }
    };

    public List<Book> GetDiscountBook(){
        List<Book> books=bookDao.GetDiscountBook();

        Queue<Book> customerPriorityQueue = new PriorityQueue<Book>(books.size(), DiscountComparator);
        for(int i=0;i<books.size();i++){
            customerPriorityQueue.add(books.get(i));
        }
        List<Book> resultbooks=new LinkedList<>();

        //默认队列大小大于10
        for(int i=0;i<8;i++){
            //System.out.println(DiscountDegree(customerPriorityQueue.peek()));
            resultbooks.add(i,customerPriorityQueue.remove());

        }
        List<Book> reverse=new LinkedList<>();
        for (int i=0;i<8;i++){
            reverse.add(resultbooks.get(7-i));
        }
        return reverse;

    }

    private static float DiscountDegree(Book book){
        //System.out.println(book.getPreprice());
        //System.out.println(book.getNowprice());
        return 100*(book.getPreprice()-book.getNowprice())/book.getPreprice();
    }

    public List<Book> GetNewBook(){
        List<Book> books=bookDao.GetAllBook();
        HashSet<Book> hashSet=new HashSet<>();
        while (hashSet.size()<10){
            Random random=new Random();
            hashSet.add(books.get(random.nextInt(books.size()) ));
        }
        List<Book> newbooks=new LinkedList<>(hashSet);
        System.out.println(newbooks.size());
        return newbooks;
    }

    public List<Book> GetCommonBook(){
        List<Book> books=bookDao.GetAllBook();
        HashSet<Book> hashSet=new HashSet<>();
        while (hashSet.size()<10){
            Random random=new Random();
            hashSet.add(books.get(random.nextInt(books.size()) ));
        }
        List<Book> newbooks=new LinkedList<>(hashSet);
        System.out.println(newbooks.size());
        return newbooks;
    }

    public void InsertBook(Book book){
        bookDao.InsertBook(book);
    }

    public int InsertAndGetId(Book book){
        bookDao.InsertAndGetId(book);
        return book.getId();
    }

    public void UpdateBookStock(int id,int stock){
        bookDao.UpdateBookStock(id,stock);
    }

    public void UpdateBookPrice(int id,int price){
        bookDao.UpdateBookPrePrice(id);
        bookDao.UpdateBookPrice(id,price);
    }


}
