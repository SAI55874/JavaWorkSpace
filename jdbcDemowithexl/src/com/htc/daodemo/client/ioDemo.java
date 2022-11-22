package com.htc.daodemo.client;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import com.htc.daodemo.model.Book;

public class ioDemo {
public static void main(String[] args) throws IOException {
		/*
		 * int value=System.in.read();
		 * 
		 * System.out.println((char)value);
		 */
	
	
	InputStreamReader ir=new InputStreamReader(System.in);
	BufferedReader br=new BufferedReader(ir);
	
	
		/*
		 * int valu=0;
		 * 
		 * while((valu=ir.read())!=-1) { System.out.println((char)valu); }
		 */
		/*
		 * String str=br.readLine(); System.out.println(str);
		 */
		/*
		 * Book book=new Book(); System.out.println("enetr the ISBN");
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
		 * FileOutputStream fout=new FileOutputStream("D:\\My Works\\book.doc", true);
		 * 
		 * fout.write(bookstr.getBytes());
		 * 
		 * fout.close();
		 * 
		 * 
		 */
	
	//FileInputStream fin=new FileInputStream("D:\\My Works\\book.doc");
	
	FileReader reader=new FileReader("D:\\My Works\\book.doc");
	
	BufferedReader buffread=new BufferedReader(reader);
	
	String book=buffread.readLine();
	
	String value[]=book.split(",");
	int id=Integer.parseInt(value[0]);
String isbn=value[1];
String booknm=value[2];
double price=Double.parseDouble(value[3]);
String authornm=value[4];
DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
String date=value[5]; 
LocalDate dt=LocalDate.parse(date,formatter); 

Book b=new Book();
b.setBookId(id);
b.setBookName(booknm);
b.setIsbnNo(isbn);
b.setPrice(price);
b.setReleasedDate(dt);
	
	
	//System.out.println(Arrays.toString(value));
System.out.println(b);
}
}
