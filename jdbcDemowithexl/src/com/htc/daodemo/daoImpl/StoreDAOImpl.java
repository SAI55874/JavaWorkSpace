package com.htc.daodemo.daoImpl;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.htc.daodemo.dao.StoreDAO;
import com.htc.daodemo.exception.BookNotFoundException;
import com.htc.daodemo.model.Book;

public class StoreDAOImpl implements StoreDAO {
	
	List<Book> books=new ArrayList<Book>();
	public StoreDAOImpl()
	{
		books.add(new Book("23525","yyyy",646,"xxx",LocalDate.of(2019, 05, 21)));
	books.add(new Book("2345654","rrr",646,"gter",LocalDate.of(2016, 11, 21)));
	}

	@Override
	public boolean addBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBook(String isbn,double price) {
		boolean flag=false;
		
		for(Book book:books)
		{
			if(book.getIsbnNo().equals(isbn)) {
			book.setPrice(price);
			flag=true;
			}
		}
		
		return flag;
	}

	@Override
	public boolean deleteBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public List<Book> getBooks(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(String isbn) throws BookNotFoundException {
		Book book=null;
		for(Book b:books)
		{
			if(b.getIsbnNo().equals(isbn)) {
			book=b;
			break;
			}
		}
		
		
		
		return book;
	}

}
