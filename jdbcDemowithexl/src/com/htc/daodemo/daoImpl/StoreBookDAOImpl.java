package com.htc.daodemo.daoImpl;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.htc.daodemo.dao.StoreBooksDAO;
import com.htc.daodemo.model.Book;

public class StoreBookDAOImpl implements StoreBooksDAO {
	
	
	ConcurrentHashMap<String, List<Book>> map=new ConcurrentHashMap<String, List<Book>>();

	@Override
	public ConcurrentHashMap<String, List<Book>> addBooksInStore(String storeId, List<Book> books) {
		// TODO -generated method stub
		
		
		map.put(storeId, books);
		
		
		
		return map;
	}

	@Override
	public ConcurrentHashMap<String, List<Book>> addBookInStore(String storeId, Book book) {
		// TODO Auto-generated method stub
		List<Book> books=map.get(storeId);
		
		System.out.println(books);
		books.add(book);
		
		System.out.println(books);
		
		return map;
	}

	@Override
	public ConcurrentHashMap<String, List<Book>> UpdateBookInStore(String storeId, String isbn, double price) {
		// TODO Auto-generated method stub
		List<Book> books=map.get(storeId);
		for(Book b:books)
		{
			if(b.getIsbnNo().equals(isbn))
			{
				b.setPrice(price);
				break;
			}
		}
		
		return map;
	}

	@Override
	public List<Book> getAllBooksbyStoreId(String storeId) {
		// TODO Auto-generated method stub
		List<Book> books=map.get(storeId);
		return books;
	}

	@Override
	public Book getBookbyStoreId(String storeId, String isbn) {
		List<Book> books=map.get(storeId);
		Book book=null;
		for(Book b:books)
		{
			if(b.getIsbnNo().equals(isbn))
			{
				book=b;
				break;
			}
		}
		
		return book;
	}

}
