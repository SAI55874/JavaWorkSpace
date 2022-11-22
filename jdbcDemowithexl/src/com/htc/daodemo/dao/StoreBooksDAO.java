package com.htc.daodemo.dao;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.htc.daodemo.model.Book;

public interface StoreBooksDAO {
	ConcurrentHashMap<String, List<Book>> addBooksInStore(String storeId,List<Book> books);
	ConcurrentHashMap<String, List<Book>> addBookInStore(String storeId,Book book);
	ConcurrentHashMap<String, List<Book>> UpdateBookInStore(String storeId,String isbn,double price);
	List<Book> getAllBooksbyStoreId(String storeId);
	Book getBookbyStoreId(String storeId,String isbn);
	
}
