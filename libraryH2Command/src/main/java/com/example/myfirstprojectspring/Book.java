package com.example.myfirstprojectspring;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOK")
public class Book {

	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "TITLE")
	private String title;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "PAGES")
	private int pages;
	@Column(name = "YEAR_PUBLISHED")
	private int yearPublished;
	@Column(name = "ISBN")
	private String isbn;
	
	
	public Book () {}
	
	public Book(int id, String title, String author, int pages, int yearPublished, String isbn ) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.yearPublished = yearPublished;
		this.isbn = isbn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public int getYearPublished() {
		return yearPublished;
	}
	public void setYearPublished(int year) {
		this.yearPublished = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String iSBN) {
		isbn = iSBN;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", author=" + author + ", pages=" + pages + ", yearPublished=" + yearPublished + ", isbn=" + isbn
				+ "]";
	}
}
