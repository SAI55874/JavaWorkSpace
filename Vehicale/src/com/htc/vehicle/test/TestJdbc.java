package com.htc.vehicle.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.htc.vehicle.DaoImpl.VehicleDaoImpl;
import com.htc.vehicle.pojo.Vehicle;



public class TestJdbc {
public static void main(String[] args) throws SecurityException, IOException {
VehicleDaoImpl vhs = new VehicleDaoImpl(); 
List<Vehicle> vhls= new ArrayList<>();
vhls=vhs.ReadExcel();
	Connection connection = null;
    try {
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/htc",
            "root", "root");

        Statement statement = null;
        
        
        
        statement = connection.createStatement();
        for (Vehicle vehicle : vhls) {
        	String sql= "INSERT INTO vehicles VALUES ("+"'"+vehicle.getVehicleNo()+"'"+","+"'"+vehicle.getBrandName()+"'"+","+"'"+vehicle.getColor()+"'"+","+"'"+vehicle.getVehicleType()+"'"+","+vehicle.getVehicalCC()+","+vehicle.getPrice()+")";
        	System.out.println(sql);
        	statement.executeUpdate(sql);
        	
		}
    //statement.executeUpdate("TRUNCATE vehicles");
        ResultSet resultSet;
        resultSet = statement.executeQuery(
            "select * from vehicles");
        
        while(resultSet.next())  
        	System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));  
        resultSet.close();
        statement.close();
        connection.close();
    }
    catch (Exception exception) {
        System.out.println(exception);
    }
}
}
