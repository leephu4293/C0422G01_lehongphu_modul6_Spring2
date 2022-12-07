package com.example.module6_spring2_be.model;

import com.example.module6_spring2_be.model.composite.BookDetailKey;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "book_detail")
public class BookDetail {
    @EmbeddedId
    private BookDetailKey id;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    @JsonBackReference
    private Book book;






}
