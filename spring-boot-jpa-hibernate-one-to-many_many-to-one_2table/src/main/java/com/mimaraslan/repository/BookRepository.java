package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mimaraslan.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

    Book findByIsbn(String isbn);
}