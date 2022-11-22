package com.htc.daodemo.exception;

public class BookNotFoundException extends Exception {
	
	public BookNotFoundException() {
		// TODO Auto-generated constructor stub
	}
	
	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookNotFoundException " +super.getMessage();
	}

}
