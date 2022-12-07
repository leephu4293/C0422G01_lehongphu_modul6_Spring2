package com.sprint2.book_store_webservice.controller;

import com.sprint2.book_store_webservice.model.Book;
import com.sprint2.book_store_webservice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/list")
    public ResponseEntity<List<Book>> getAllBook (){
        List<Book> list = this.bookService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

}
