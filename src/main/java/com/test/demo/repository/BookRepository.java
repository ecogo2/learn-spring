package com.test.demo.repository;

import com.test.demo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository //ekstenda sve metode koje provajta JPA, al pravimo za naš model
public interface BookRepository extends JpaRepository<Book, Long> {
}
