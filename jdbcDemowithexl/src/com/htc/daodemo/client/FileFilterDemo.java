package com.htc.daodemo.client;

import java.io.*;

class OnlyExt implements FilenameFilter {
	String ext;

	public OnlyExt(String ext) {
		this.ext = "." + ext;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}
}

public class FileFilterDemo {
	public static void main(String[] args) {
		String dirname = "D:\\My Works"; // LINE A
		File f1 = new File(dirname); // LINE B
		String[] allFiles = f1.list(); // LINE C

		System.out.println("Printing all files in the directory.");
		for (int i = 0; i < allFiles.length; i++) {
			System.out.println(allFiles[i]);
		}
		System.out.println("-----------------------");

		
		  FilenameFilter only = new OnlyExt("zip"); // LINE D
		  System.out.println("Printing files after filtering.");
		  
		  String s[] = f1.list(only); // LINE E
		  for(int i = 0; i < s.length; i++) {
		  System.out.println(s[i]); }
		 

		/*
		 * FilenameFilter fnf=new FilenameFilter() {
		 * 
		 * @Override public boolean accept(File dir, String name) { // TODO
		 * Auto-generated method stub return name.endsWith(".xml"); } };
		 * 
		 * String[] s=f1.list(fnf); for (String string : s) {
		 * System.out.println(string);
		 * 
		 * }
		 */

	}

}
