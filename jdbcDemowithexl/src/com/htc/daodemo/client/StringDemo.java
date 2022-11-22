package com.htc.daodemo.client;

public class StringDemo {
public static void main(String[] args) {
	String st="HI";
	String s="HI";
	String str=new String("HI");
	
	if(st==str)
		System.out.println(" equal");
	else
		System.out.println("not equal");
	
	if(st==s)
		System.out.println(" equal");
	else
		System.out.println("not equal");
	
	
	
	
	
	
	
	str=str.concat("Hello");
	System.out.println(str);
}
}
