package com.test.demo.model;

import com.test.demo.model.dto.BookDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Getter// skraćenica da napravi sve gettere i settere
@Setter
@NoArgsConstructor // napravi konstruktor bez argumenata (potreban je za mapiranje)
@Table
@Entity(name = "book") // kaže hibernateu da napravi tabelu imena book
public class Book {

    @Id //kaže hibernateu da će ovo bit identifier u tabeli
    @Column(name = "id") // kaže hibernateu kako da nazove kolonu u tabeli (može se razlikovati od imena atributa)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "number_of_pages") // razlikuje se u tabeli od imena varijable al će znat on šta je šta
    private int numberOfPages;


    public Book(BookDTO book) {
        this.id = book.getId();
        this.name = book.getName();
        this.numberOfPages = book.getNumberOfPages();
    }
}

