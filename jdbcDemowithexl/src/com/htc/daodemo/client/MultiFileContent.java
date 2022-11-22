package com.htc.daodemo.client;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class MultiFileContent {
public static void main(String[] args) throws IOException {

	String str="Tis is the demo to explain multi file concept";
	
		/*
		 * ByteArrayOutputStream bout=new ByteArrayOutputStream();
		 * 
		 * try { bout.write(str.getBytes()); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 */
	
	
	CharArrayWriter charwriter=new CharArrayWriter();
	charwriter.write(str);
	
	/*FileOutputStream fout=new FileOutputStream("cfout.txt");
	FileOutputStream fout1=new FileOutputStream("cfout1.txt");
	FileOutputStream fout2=new FileOutputStream("cfout2.txt");
	FileOutputStream fout3=new FileOutputStream("cfout3.txt");*/
	
	
	FileWriter f=new FileWriter("cf.txt");
	FileWriter f1=new FileWriter("cf1.txt");
		/*
		 * bout.writeTo(fout); bout.writeTo(fout1); bout.writeTo(fout2);
		 * bout.writeTo(fout3);
		 */
	
	charwriter.writeTo(f);
	charwriter.writeTo(f1);
	
	
	charwriter.flush();
	f.close();
	f1.close();
	
	
}
}
