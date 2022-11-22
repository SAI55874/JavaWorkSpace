package com.htc.daodemo.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.htc.daodemo.model.Book;

public class SerializeDemo {
public static void main(String[] args) throws IOException {
	InputStreamReader ir=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(ir);
	
	
		
		  
		
		
		/*
		 * Book book=new Book();
		 * 
		 * System.out.println("enetr the ISBN");
		 * 
		 * book.setIsbnNo(br.readLine());
		 * 
		 * System.out.println("enetr the bookname"); book.setBookName(br.readLine());
		 * System.out.println("enetr the price");
		 * 
		 * double price=Double.parseDouble(br.readLine()); book.setPrice(price);
		 * 
		 * System.out.println("enetr the author"); book.setAuthorName(br.readLine());
		 * System.out.println("enetr the publishedDate"); DateTimeFormatter
		 * formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy"); String
		 * date=br.readLine(); LocalDate dt=LocalDate.parse(date,formatter);
		 * book.setReleasedDate(dt);
		 * 
		 * System.out.println(book); String bookstr=book.toString();
		 * 
		 * FileOutputStream fout=new FileOutputStream("D:\\My Works\\book.txt");
		 * ObjectOutputStream out=new ObjectOutputStream(fout);
		 * 
		 * out.writeObject(book);
		 * 
		 * out.close(); fout.close();
		 */
		 
		 
		 
		  
		  File file=new File("D:\\My Works\\book.txt");
		
		  Book book=null; FileInputStream fin=new
		  FileInputStream(file); ObjectInputStream objin=new
		  ObjectInputStream(fin);
		  
		  try { book=(Book) objin.readObject(); } catch (ClassNotFoundException e) { //
		  e.printStackTrace(); }
		  
		  System.out.println(book);
		 
		 
		 
		 
}
}
