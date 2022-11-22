package com.htc.daodemo.dao;


import java.util.List;

import com.htc.daodemo.exception.BookNotFoundException;
import com.htc.daodemo.model.Book;

public interface StoreDAO {
	boolean addBook(Book book);
	boolean updateBook(String isbn,double price) throws BookNotFoundException;
	boolean deleteBook(Book book) throws BookNotFoundException;
	List<Book> getBooks() throws BookNotFoundException;
	List<Book> getBooks(String authorName) throws BookNotFoundException;
	Book getBook(String isbn) throws BookNotFoundException;
	
	

}
