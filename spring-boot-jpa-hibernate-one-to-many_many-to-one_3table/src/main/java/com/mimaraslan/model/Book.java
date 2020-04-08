package com.mimaraslan.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String author;

	@Column(unique = true)
	private String isbn;

	@ManyToOne
	@JoinColumn(name = "book_category_id", nullable = false)
	private BookCategory bookCategory;

	@JsonIgnoreProperties("book") // for Hibernate N+1 Queries Problem
	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Page> pages;

	public Book() {
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(String title, String author, String isbn, BookCategory bookCategory) {
		this.title = title;
		this.author = author;
		this.isbn = isbn;
		this.bookCategory = bookCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Page> getPages() {
		return pages;
	}

	public void setPages(Set<Page> pages) {
		this.pages = pages;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Book book = (Book) o;
		return id.equals(book.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}