package com.htc.daodemo.model;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;

public class Book implements Serializable,Comparable<Book> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int counter=0;
	transient private int bookId;
	 public int getBookId() {
		return bookId;
	}
	public void setBookId() {
		
		//this.bookId = counter++;
	}
public Book(String bookName )
{
	this.bookName = bookName;
}
public Book( )
{

}


public Book(String bookName,String authorName )
{
	this.bookName = bookName;
	this.authorName = authorName;
}

	public Book( String isbnNo, String bookName, double price, String authorName, LocalDate releasedDate) {
		
		this.bookId = ++counter;
		this.isbnNo = isbnNo;
		this.bookName = bookName;
		this.price = price;
		this.authorName = authorName;
		this.releasedDate = releasedDate;
	}

	private String isbnNo;//instance variable
	private String bookName;
	private double price;
	transient private String authorName;
	private LocalDate releasedDate;
	public static int noofView;//static variable
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public LocalDate getReleasedDate() {
		return releasedDate;
	}
	public void setReleasedDate(LocalDate releasedDate) {
		this.releasedDate = releasedDate;
	}
	public String getIsbnNo() {
		return isbnNo;
	}
	public void setIsbnNo(String isbnNo) {
		
		this.isbnNo = isbnNo;
	}
	
	public int addView()
	{
		noofView=noofView++;
		
		return noofView;
		
	}
	
	public static int addView1()
	{
		
		noofView=noofView++;
		//System.out.println(isbnNo);
		return noofView;
		
	}
	
	@Override
	public String toString() {
		return   bookId + "," + isbnNo + "," + bookName + ", " + price
				+ "," + authorName + ", " + releasedDate ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbnNo == null) ? 0 : isbnNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbnNo == null) {
			if (other.isbnNo != null)
				return false;
		} else if (!isbnNo.equals(other.isbnNo))
			return false;
		return true;
	}
	
	
	  @Override public int compareTo(Book o) { // TODO Auto-generated method stub
	  return new Double(this.getPrice()).compareTo(o.getPrice()); }
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	 
	 
	
	
	
	

}


