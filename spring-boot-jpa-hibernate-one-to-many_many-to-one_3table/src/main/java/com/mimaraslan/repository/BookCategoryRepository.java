package com.mimaraslan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mimaraslan.model.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

		
}