package com.devil.music.common.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Devil on 2017/3/24.
 */

public class BookContent {
    public static class Book{
        public Integer id;
        public String title;
        public String desc;

        public Book(Integer id,String title,String desc){
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString(){
            return title;
        }
    }

    public static List<Book> ITEMS = new ArrayList<Book>();
    public static Map<Integer,Book> ITEM_MAP = new HashMap<Integer,Book>();

    static{
        addItem(new Book(1,"疯狂的Java讲义","一本全面、深入的Java学习图书，已被多家高校选作教材"));
        addItem(new Book(2,"疯狂的Android讲义","Android学习者的首选教材"));
        addItem(new Book(3,"轻量级Java EE企业应用实战","全面介绍Java EE开发的Struts 2、Spring 3、Hibernate 4框架"));
    }

    public static void addItem(Book book){
        ITEMS.add(book);
        ITEM_MAP.put(book.id,book);
    }
}
