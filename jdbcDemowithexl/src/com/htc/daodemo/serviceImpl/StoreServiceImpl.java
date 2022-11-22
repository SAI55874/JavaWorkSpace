package com.htc.daodemo.serviceImpl;

import java.util.List;

import com.htc.daodemo.dao.StoreDAO;
import com.htc.daodemo.daoImpl.StoreDAOImpl;
import com.htc.daodemo.exception.BookNotFoundException;
import com.htc.daodemo.model.Book;
import com.htc.daodemo.service.storeService;

public class StoreServiceImpl implements storeService{

	
	StoreDAO dao=new StoreDAOImpl();
	@Override
	public boolean storeBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifyBook(String isbn,double price) {
		// TODO Auto-generated method stub
		//return dao.updateBook(isbn, price);
		return false;
	}

	@Override
	public boolean removeBook(Book book) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Book> getallAvaiable() {
		// TODO Auto-generated method stub
		List<Book> booklist=null;
		try {
			 booklist=dao.getBooks();
		} catch (BookNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return booklist;
	}

	@Override
	public List<Book> getBooksByAuthor(String authorName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getBook(String isbn) throws BookNotFoundException {
		
		
		
		// TODO Auto-generated method stub
		return dao.getBook(isbn);
	}

}
