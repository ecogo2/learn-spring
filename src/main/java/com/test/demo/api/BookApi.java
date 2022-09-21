package com.test.demo.api;

import com.test.demo.model.Book;
import com.test.demo.model.dto.BookDTO;
import com.test.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController // kaže springu da je kontroler i može prihvatat requestove
public class BookApi {

    @Autowired // daje nam mogućnost da pozovemo repozitorij u ovoj klasi
    BookRepository bookRepository;

    @GetMapping(path = "/books") //govori koji tip requesta prima i na koji url; ovo ispadne: GET na -> localhost:8080/books
    List<Book> getBooks() {
        return bookRepository.findAll(); // poziva metodu iz repozitorija koja vraća sve knjige
    }

    @PostMapping(path = "/create-book")
    // POST na -> localhost:8080/create-book; body requesta npr {"id": 123, "name" : "Orlovi rano lete", "numberOfPages" : 200}
    public Book createBook(@RequestBody BookDTO book) {
        // iz primljenog objekta BookDTO se napravi Entity objekat Book kojim hibernate zna baratat i zna snimit u bazu
        Book bookEntity = new Book(book);
        // i onda se snimi u bazu
        return bookRepository.save(bookEntity);
    }

}
