package com.sprint2.book_store_webservice.repository;

import com.sprint2.book_store_webservice.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book,Long> {

}
