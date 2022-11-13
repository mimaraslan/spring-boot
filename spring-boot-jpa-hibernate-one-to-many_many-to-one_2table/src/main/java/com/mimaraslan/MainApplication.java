package com.mimaraslan;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mimaraslan.model.Book;
import com.mimaraslan.model.Page;
import com.mimaraslan.repository.BookRepository;
import com.mimaraslan.repository.PageRepository;

@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {


            // create a new book
            Book book1 = new Book("Java 101", "Katerina Lena", "123456");

            // save the book
            bookRepository.save(book1);

            // create and save new pages
            pageRepository.save(new Page(1, "Introduction contents", "Introduction", book1));
            pageRepository.save(new Page(14, "Java contents", "Java", book1));
            pageRepository.save(new Page(53, "Concurrency contents", "Concurrency", book1));


            // create a new book
            Book book2 = new Book("Scala 101", "Yulya Rita", "987654");

            // save the book
            bookRepository.save(book2);

            // create and save new pages
            pageRepository.save(new Page(1, "PART 1", "Scala", book2));
            pageRepository.save(new Page(20, "PART 2", "Play", book2));
            pageRepository.save(new Page(60, "PART 3", "Akka", book2));

        };
    }
}