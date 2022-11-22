package com.htc.daodemo.client;

import java.io.File;
import java.io.FileFilter;

public class FilelenghtDemo {
public static void main(String[] args) {
	File folder = new File("D:\\My Works");
    
    //Implementing FileFilter to retrieve the files smaller than 10MB
     
    FileFilter sizeFilter = new FileFilter() 
    {    
        @Override
        public boolean accept(File file) 
        {
            if(file.length() < 2*1024*1024)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    };
     
    //Passing sizeFilter to listFiles() method
     
    File[] files = folder.listFiles(sizeFilter);
     
    for (File file : files) 
    {
        System.out.println(file.getName());
    }
}
}
