package com.codegym.borrow_book.service;

import com.codegym.borrow_book.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    boolean rentBook( Book book);

    void giveBookBack(Book book);
}
