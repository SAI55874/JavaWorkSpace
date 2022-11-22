package com.htc.daodemo.dbutil;

import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Properties;



public class DBUtil {
	
	static Connection con=null;
	
	public static Connection getConnection()
	
	
	{
		Properties props=new Properties(); try { props.load(new
				  FileReader("D:\\bavani Backup\\javatraining\\data.properties")); }
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
	
	/*
	 * public static void main(String[] args) throws SQLException {
	 * 
	 * Connection con=null; //Statement st=null; PreparedStatement pst=null;
	 * ResultSet rs=null; CallableStatement cst=null;
	 * 
	 * Properties props=new Properties(); try { props.load(new
	 * FileReader("D:\\My Works\\data.properties")); } catch (IOException e1) { //
	 * TODO Auto-generated catch block e1.printStackTrace(); }
	 * 
	 * try { Class.forName(props.getProperty("driver")); } catch
	 * (ClassNotFoundException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * try {
	 * con=DriverManager.getConnection(props.getProperty("url"),props.getProperty(
	 * "username"), props.getProperty("password")); } catch (SQLException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } String
	 * SQL="select id,name,email from employee where id=?"; try {
	 * //st=con.createStatement(); pst=con.prepareStatement(SQL); pst.setInt(1, 1);
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); }
	 * 
	 * 
	 * try { //rs=st.executeQuery(SQL); rs=pst.executeQuery(); while(rs.next()) {
	 * System.out.println(rs.getInt("id")+"\t"+rs.getString("name")+"\t"+rs.
	 * getString("email")); } } catch (SQLException e) { // TODO Auto-generated
	 * catch block e.printStackTrace(); }
	 * 
	 * rs=null; System.out.println("_____________________call __________________");
	 * 
	 * cst=con.prepareCall("{call getEmployees()}");
	 * 
	 * rs=cst.executeQuery(); while(rs.next()) {
	 * System.out.println(rs.getInt("empid")+"\t"+rs.getString("empname")+"\t"+rs.
	 * getString("mail")); }
	 * 
	 * 
	 * LocalDate localdate=LocalDate.now(); java.sql.Date
	 * dt=java.sql.Date.valueOf(localdate); System.out.println(dt);
	 * 
	 * LocalDate local=dt.toLocalDate(); System.out.println(local);
	 * 
	 * 
	 * }
	 * 
	 */
}
