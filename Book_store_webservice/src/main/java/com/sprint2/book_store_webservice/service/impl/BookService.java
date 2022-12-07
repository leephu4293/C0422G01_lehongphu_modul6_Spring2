package com.sprint2.book_store_webservice.service.impl;

import com.sprint2.book_store_webservice.model.Book;
import com.sprint2.book_store_webservice.repository.IBookRepository;
import com.sprint2.book_store_webservice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService  implements IBookService {
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public List<Book> findBookByTitleContains(String title) {
        return this.bookRepository.findBookByTitleContains(title);
    }


}
