package com.htc.daodemo.service;


import java.util.List;

import com.htc.daodemo.exception.BookNotFoundException;
import com.htc.daodemo.model.Book;

public interface storeService {
	boolean storeBook(Book book);
	boolean modifyBook(String isbn,double price);
	boolean removeBook(Book book);
	List<Book> getallAvaiable();
	List<Book> getBooksByAuthor(String authorName);
	Book getBook(String isbn) throws BookNotFoundException;
	
	
	
	
}
