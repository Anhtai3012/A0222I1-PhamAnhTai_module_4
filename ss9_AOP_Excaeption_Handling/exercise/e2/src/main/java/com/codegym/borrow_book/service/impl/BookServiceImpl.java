package com.codegym.borrow_book.service.impl;

import com.codegym.borrow_book.model.Book;
import com.codegym.borrow_book.service.IBookService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@Service
public class BookServiceImpl  implements IBookService {
    private static Map<Integer, Book> books=new HashMap<>();

    static {
        books.put(0,new Book(0,"Rich Dad Poor Dad",30));
        books.put(1,new Book(1,"The 7 Habits of highly Effective People",12));
        books.put(2,new Book(2,"How to win Friends and Influence People",2));
    }


    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<Book>(books.values());
    }

    @Override
    public Book getBookById(int id) {
        Book book=books.get(id);
        if(book!=null) {
            return book;
        }
        return null;
    }

    @Override
    public boolean rentBook(Book book) {
        Book temp=books.get(book.getId());
        if(temp.getAmount()==0) {
            return false;
        } else {
            temp.setAmount(temp.getAmount()-1);
//            books.replace(book.getId(), book);
            return true;
        }
    }

    @Override
    public void giveBookBack(Book book) {
        Book temp=books.get(book.getId());
        if(temp!=null) {
            temp.setAmount(temp.getAmount()+1);
        }
    }
}
