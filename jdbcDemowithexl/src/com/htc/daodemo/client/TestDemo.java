package com.htc.daodemo.client;

import java.util.Iterator;
import java.util.List;

import com.htc.daodemo.exception.BookNotFoundException;
import com.htc.daodemo.model.Book;
import com.htc.daodemo.service.storeService;
import com.htc.daodemo.serviceImpl.StoreServiceImpl;

public class TestDemo {
public static void main(String[] args) {
	
storeService service=new StoreServiceImpl();

Book book=null;

try {
	book=service.getBook("23525");
	if(book==null)
		throw new BookNotFoundException("No search Found");
	else
	{
		System.out.println(book.getBookName());

	}
} catch (BookNotFoundException e) {
	// TODO Auto-generated catch block
	System.out.println(e.getMessage());
}




		/*
		 * if(service.modifyBook("23525", 1006.99)) System.out.println("updated");
		 * 
		 * List<Book> list=service.getallAvaiable();
		 * 
		 * 
		 * for (Iterator iterator = list.iterator(); iterator.hasNext();) { Book book =
		 * (Book) iterator.next();
		 * 
		 * System.out.println(book);
		 * 
		 * }
		 * 
		 */
}
}
