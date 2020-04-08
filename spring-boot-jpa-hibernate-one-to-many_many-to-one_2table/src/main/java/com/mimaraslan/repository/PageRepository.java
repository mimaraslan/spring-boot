package com.mimaraslan.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mimaraslan.model.Book;
import com.mimaraslan.model.Page;

import java.util.List;

public interface PageRepository extends JpaRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}