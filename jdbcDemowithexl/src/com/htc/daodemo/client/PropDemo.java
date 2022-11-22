package com.htc.daodemo.client;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropDemo {
public static void main(String[] args) throws FileNotFoundException, IOException {
	Properties prop=new Properties();
	prop.load(new FileInputStream("D:\\My Works\\data.properties"));
	
	System.out.println(prop.getProperty("url"));
	System.out.println(prop.getProperty("username"));
	
	System.out.println(prop.getProperty("password"));
}
}
