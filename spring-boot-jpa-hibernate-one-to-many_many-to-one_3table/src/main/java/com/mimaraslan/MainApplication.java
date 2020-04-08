package com.mimaraslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mimaraslan.model.Book;
import com.mimaraslan.model.BookCategory;
import com.mimaraslan.model.Page;
import com.mimaraslan.repository.BookCategoryRepository;
import com.mimaraslan.repository.BookRepository;
import com.mimaraslan.repository.PageRepository;

@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}

	@Bean
	public CommandLineRunner mappingDemo(BookCategoryRepository bookCategoryRepository, BookRepository bookRepository,
			PageRepository pageRepository) {
		return args -> {

			BookCategory bookCategory1 = new BookCategory("Object Oriented Programming");
			bookCategoryRepository.save(bookCategory1);

			BookCategory bookCategory2 = new BookCategory("Functional Programming");
			bookCategoryRepository.save(bookCategory2);

			// create a new book
			Book book1 = new Book("Java EE", "Katerina Lena", "123456", bookCategory1);

			// save the book
			bookRepository.save(book1);

			// create and save new pages
			pageRepository.save(new Page(1, "Java 101", "Java Level 1", book1));
			pageRepository.save(new Page(14, "Java 102", "Java Level 2", book1));
			pageRepository.save(new Page(53, "Java 103", "Java Level 3", book1));

			// create a new book
			Book book2 = new Book("Scala 101", "Yulya Rita", "987654", bookCategory2);

			// save the book
			bookRepository.save(book2);

			// create and save new pages
			pageRepository.save(new Page(1, "PART 1", "Scala", book2));
			pageRepository.save(new Page(20, "PART 2", "Play", book2));
			pageRepository.save(new Page(60, "PART 3", "Akka", book2));

		};
	}
}