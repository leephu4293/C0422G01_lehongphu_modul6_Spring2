package com.example.module6_spring2_be.model.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookDetailKey implements Serializable {
    @Column(name = "book_id")
    private Integer bookId;
    @Column(name = "category_id")
    private Integer categoryId;


}
