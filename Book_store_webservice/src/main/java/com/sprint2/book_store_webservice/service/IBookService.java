package com.sprint2.book_store_webservice.service;

import com.sprint2.book_store_webservice.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
}
