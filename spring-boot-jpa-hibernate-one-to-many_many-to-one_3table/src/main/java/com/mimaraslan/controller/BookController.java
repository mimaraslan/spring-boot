package com.mimaraslan.controller;

import com.mimaraslan.model.Book;
import com.mimaraslan.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    // http://localhost:8082/api/v1/books
    @GetMapping("/books")
    public List<Book> getBooksAll() {
        return bookRepository.findAll();
    }

    // http://localhost:8082/api/v1/books/1
    @GetMapping("/books/{id}")
    public ResponseEntity<Optional<Book>> getBookFindById(@PathVariable("id") Long id) {
        Optional<Book> book = bookRepository.findById(id);
        return ResponseEntity.ok().body(book);
    }
}