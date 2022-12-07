package com.sprint2.book_store_webservice.controller;

import com.sprint2.book_store_webservice.model.Book;
import com.sprint2.book_store_webservice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping("/api/public/list")
    public ResponseEntity<List<Book>> getAllBook (){
        List<Book> list = this.bookService.findAll();
        if (list.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @GetMapping("/api/public/search")
    public ResponseEntity<List<Book>> getBookSearch(@RequestParam String name){
        List<Book> list = this.bookService.findBookByTitleContains(name);
        if (list.isEmpty()){
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list,HttpStatus.OK);
    }


}
