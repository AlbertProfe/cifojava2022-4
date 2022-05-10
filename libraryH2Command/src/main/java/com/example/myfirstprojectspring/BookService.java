package com.example.myfirstprojectspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookrepository;
	
	public Iterable<Book> queryBooksFromH2() {
		
		//System.out.println ("Books" + books);
		
		return bookrepository.findAll();
	}
	
	public Book addBookToH2(Book book) {
		
		bookrepository.save(book);
		
		return book;
	}

}
