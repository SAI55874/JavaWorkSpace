package com.htc.vehicle.DbUtil;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
static Connection con=null;
	
	public static Connection getConnection()
	
	
	{
		Properties props=new Properties(); try { 
			props.load(
				new FileReader("data.properties")
				); 
		}
		catch (IOException e1) { 
				 e1.printStackTrace(); }
				  
				  try { Class.forName(props.getProperty("db.drivername")); } 
				  catch
				  (ClassNotFoundException e) {
					  // TODO Auto-generated catch block
				  e.printStackTrace(); }
				  
				  try {
						 con=DriverManager.getConnection(props.getProperty("db.url"),props.getProperty(
						  "db.username"), props.getProperty("db.password")); }
				  catch (SQLException e) { 
					  e.printStackTrace();
				  }
		
		
		return con;
	}
}
