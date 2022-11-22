package com.htc.daodemo.client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.htc.daodemo.dao.StoreBooksDAO;
import com.htc.daodemo.daoImpl.StoreBookDAOImpl;
import com.htc.daodemo.model.Book;
import com.htc.daodemo.model.Store;

public class clientDemoMap {
public static void main(String[] args) {
	
	Store store1=new Store("1234","ABC store");
	List<Book> book_store1=new ArrayList<Book>(3);
	book_store1.add(new Book("456","Book1",345.67,"author1",LocalDate.of(2015,9, 15)));
	book_store1.add(new Book("457","Book2",385.67,"author2",LocalDate.of(2016,8, 15)));
StoreBooksDAO dao=new StoreBookDAOImpl();
	ConcurrentHashMap<String,List<Book>> map=new ConcurrentHashMap<String, List<Book>>();
			
			
			map=dao.addBooksInStore(store1.getStoreId(), book_store1);
	store1.setStore_books(map);
	
	System.out.println(store1);
	
	
	Book book=new Book("4578","Book3",385.67,"author3",LocalDate.of(2016,8, 15));
	
	 map=dao.addBookInStore(store1.getStoreId(), book);
	 store1.setStore_books(map);
		
	 System.out.println(store1);
	 
	 map=dao.UpdateBookInStore(store1.getStoreId(),book.getIsbnNo(),678.90);
	 store1.setStore_books(map);
		
	 System.out.println(store1);
	 
	 
	
	
}
}
