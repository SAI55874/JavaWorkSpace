package com.htc.vehicle.DaoImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.vehicle.LogUtil.LogUtil;
import com.htc.vehicle.Service.VehicleService;
import com.htc.vehicle.ServiceImpl.VehicleServiceImpl;

import com.htc.vehicle.Dao.VehicleDao;
import com.htc.vehicle.DbUtil.DbUtil;
import com.htc.vehicle.Exceptions.VehicleAlreadyExists;
import com.htc.vehicle.Exceptions.VehicleNotFound;
import com.htc.vehicle.pojo.Vehicle;

public class VehicleDaoImpl implements VehicleDao{

	Logger logger=null;
	Connection connection = null;
	List <Vehicle> vehicles=new ArrayList<>();
	
	public VehicleDaoImpl() throws SecurityException, IOException {
		logger=LogUtil.getLog(Class.class.getName());	
//		Vehicle vehicle1=new Vehicle("AP_39_PD_2121","Audi","white","Car",4000,1000000);
//		Vehicle vehicle2=new Vehicle("AP_39_PD_2123","benz","black","Car",4000,1000000);
//		vehicles.add(vehicle1);
//		vehicles.add(vehicle2);
//		vehicles.add(new Vehicle("AP_39_PD_2121","Audi","white","Car",3000,20000000));
//		vehicles.add(new Vehicle("TN_39_PD_2123","Benz","black","Car",3500,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_3345","MaruthisuZuki","black","Car",3200,500000));
//		vehicles.add(new Vehicle("MP_39_PD_6464","Tataindica","black","Car",2400,600000));
//		vehicles.add(new Vehicle("AP_39_PD_9999","Hundai","black","Car",4000,700000));
//		vehicles.add(new Vehicle("UP_39_PD_3363","Kia","black","Car",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_9812","Ashokleyland","black","Lorry",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_6363","Kia","black","Car",2500,1000000));
//		vehicles.add(new Vehicle("TS_39_PD_8945","Isuzu","black","Car",2000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_7281","benz","black","Car",2000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_7382","RossRoyels","black","Car",6000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_9738","Ferrari","black","Car",8000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_9373","Benz","black","Lorry",8000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_9272","Benz","black","Car",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_9929","Mahindra","black","Lorry",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_8383","Fz","black","Bike",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_7783","Pulser","black","Bike",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_2122","Benz","black","Car",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_2132","Hero","black","Bike",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_7878","Tata","black","Car",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_5353","Asholeyland","black","Lorry",4000,1000000));
//		vehicles.add(new Vehicle("AP_39_PD_8282","JCB","black","Drozer",4000,1000000));
	}
	
	
	@Override
	public boolean addVehicle(Vehicle vehicle) {
		boolean flag=false;
		vehicles.add(vehicle);
		flag=true;
		return flag;
		
		
		
		
	}

	@Override
	public boolean removeVehicle(String vehicleNo) throws VehicleNotFound {
		
		boolean flag = false;

		
		Vehicle veh = null;
		for (Vehicle vehicle : vehicles) {
			if(vehicleNo.equals(vehicle.getVehicleNo())) {
				vehicles.remove(vehicle);
				logger.info("vehicle removed");
				break;
			}
		}
		flag=true;
		return flag;
	}

	@Override
	public Vehicle modifyVehicle(String brandName,String VehicleType,String VehicleNo,int price) {

		
		for (Vehicle vehicle : vehicles) {
			if(VehicleNo.equals(vehicle.getVehicleNo())) {
				vehicle.setBrandName(brandName);
				vehicle.setVehicleType(VehicleType);
				vehicle.setPrice(price);
				break;
			}
		}
		
		
		return null;
	}

	


	@Override
	public List<Vehicle> getAllVehicles() {
		
		return vehicles;
	}


	@Override
	public Optional<Vehicle> getVehicle(String vehicleNo) throws VehicleNotFound {
		Vehicle veh = null;
		for (Vehicle vehicle : vehicles) {
			if(vehicleNo.equals(vehicle.getVehicleNo())) {
				veh=vehicle;
				break;
			}
		}
		logger.info("fetchedVehicledetails");
		return Optional.ofNullable(veh);
	}
	
	
	public String writeExcel() throws IOException {
		
		
		Workbook workbook=new XSSFWorkbook();
		Sheet sh = workbook.createSheet("VehicleDetails");
		String[] columnHeadings = {"VehicleNo","brandName","color","vehicleType","VehicalCC","price"};
		Font headerFont = workbook.createFont();
		
		headerFont.setFontHeightInPoints((short)14);
		headerFont.setColor(IndexedColors.BLUE.index);
		CellStyle headerStyle = workbook.createCellStyle();
		headerStyle.setFont(headerFont);
		
		sh.createFreezePane(0, 1);
		
		Row headerRow=sh.createRow(0);
		for(int i=0;i<columnHeadings.length;i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(columnHeadings[i]);
			cell.setCellStyle(headerStyle);
		}
		
		List<Vehicle> list=vehicles;
		CreationHelper creationHelper = workbook.getCreationHelper();
		CellStyle dataStyle = workbook.createCellStyle();
		int rownum=1;
		for (Vehicle vehicle : list) {
			Row row = sh.createRow(rownum++);
			row.createCell(0).setCellValue(vehicle.getVehicleNo());
			row.createCell(1).setCellValue(vehicle.getBrandName());
			row.createCell(2).setCellValue(vehicle.getColor());
			row.createCell(3).setCellValue(vehicle.getVehicleType());
			row.createCell(4).setCellValue(vehicle.getVehicalCC());
			row.createCell(5).setCellValue(vehicle.getPrice());
			
		}
		for(int i=0;i<columnHeadings.length;i++) {
			sh.autoSizeColumn(i);
		}
		FileOutputStream fileOut = new FileOutputStream("VehicleDetails34.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		logger.info("writeCompleted");
		return null;
		
	}
	
	
	public List<Vehicle> ReadExcel() throws IOException {
		FileInputStream fileInput = new FileInputStream("VehicleDetails5.xlsx");


		
		Workbook workbook = new XSSFWorkbook(fileInput);
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Sheet> sheets = workbook.sheetIterator();
		
			Sheet sh =sheets.next();
//			System.out.println("Sheet name is"+sh.getSheetName());
			Iterator<Row> iterator = sh.iterator();
			iterator.next();
			while(iterator.hasNext()) {
				Vehicle v = new Vehicle(); 
				Row row = iterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					int columnIndex=cell.getColumnIndex();
					String cellValue = dataFormatter.formatCellValue(cell);
					String value= null;
					int valueNum = 0 ;

					
					switch (columnIndex) {
	                case 0:
	                	
	                	value=cell.getStringCellValue();
	                	String vehicleNo=value;
	                    v.setVehicleNo(vehicleNo);
	                   
	                    break;
	                case 1:
	                	value=cell.getStringCellValue();
	                   String brandName=value;
	                  
	                   v.setBrandName(brandName);
	                   
	                    break;
	                case 2:
	                	value=cell.getStringCellValue();
	                	
	                  String color=value;
	                  v.setColor(color);
	                 
	                    break;
	                case 3:
	                	value=cell.getStringCellValue();
	                	
	                    String vehicleType=value;
	                    v.setVehicleType(vehicleType);
	                    
	                      break;
	                
	                case 4:
	                     valueNum= (int) cell.getNumericCellValue();
	                    
	                    int vehicleCC=valueNum;
	                    v.setVehicalCC(vehicleCC);
	                   
	                      break;
	                case 5:
	                     valueNum=(int) cell.getNumericCellValue();
	                     
	                    int price=valueNum;
	                    v.setPrice(price);
	                   
	                      break;
	                
					
				}
				
			}vehicles.add(v);
			
		}
			
		
		workbook.close();
		
		
		return vehicles ;
		
}
	
	public void ExcelToDb() throws IOException{
		List<Vehicle> vhls= new ArrayList<>();
FileInputStream fileInput = new FileInputStream("VehicleDetails5.xlsx");


		
		Workbook workbook = new XSSFWorkbook(fileInput);
		DataFormatter dataFormatter = new DataFormatter();
		Iterator<Sheet> sheets = workbook.sheetIterator();
		
			Sheet sh =sheets.next();
//			System.out.println("Sheet name is"+sh.getSheetName());
			Iterator<Row> iterator = sh.iterator();
			iterator.next();
			while(iterator.hasNext()) {
				Vehicle v = new Vehicle(); 
				Row row = iterator.next();
				Iterator<Cell> cellIterator = row.iterator();
				
				while(cellIterator.hasNext()) {
					
					Cell cell = cellIterator.next();
					int columnIndex=cell.getColumnIndex();
					String cellValue = dataFormatter.formatCellValue(cell);
					String value= null;
					int valueNum = 0 ;

					
					switch (columnIndex) {
	                case 0:
	                	
	                	value=cell.getStringCellValue();
	                	String vehicleNo=value;
	                    v.setVehicleNo(vehicleNo);
	                   
	                    break;
	                case 1:
	                	value=cell.getStringCellValue();
	                   String brandName=value;
	                  
	                   v.setBrandName(brandName);
	                   
	                    break;
	                case 2:
	                	value=cell.getStringCellValue();
	                	
	                  String color=value;
	                  v.setColor(color);
	                 
	                    break;
	                case 3:
	                	value=cell.getStringCellValue();
	                	
	                    String vehicleType=value;
	                    v.setVehicleType(vehicleType);
	                    
	                      break;
	                
	                case 4:
	                     valueNum= (int) cell.getNumericCellValue();
	                    
	                    int vehicleCC=valueNum;
	                    v.setVehicalCC(vehicleCC);
	                   
	                      break;
	                case 5:
	                     valueNum=(int) cell.getNumericCellValue();
	                     
	                    int price=valueNum;
	                    v.setPrice(price);
	                   
	                      break;
	                
					
				}
				
			}vehicles.add(v);
			
		}
			
		
		workbook.close();
		
		vhls=vehicles;
		connection=DbUtil.getConnection();
			
		    try {
		       
//		        Class.forName("com.mysql.cj.jdbc.Driver");
//		        connection = DriverManager.getConnection(
//		            "jdbc:mysql://localhost:3306/htc",
//		            "root", "root");

		        Statement statement = null;
		        
		        
		        
		        statement = connection.createStatement();
		        for (Vehicle vehicle : vhls) {
		        	String sql= "INSERT INTO vehicles VALUES ("+"'"+vehicle.getVehicleNo()+"'"+","+"'"+vehicle.getBrandName()+"'"+","+"'"+vehicle.getColor()+"'"+","+"'"+vehicle.getVehicleType()+"'"+","+vehicle.getVehicalCC()+","+vehicle.getPrice()+")";
//		        	System.out.println(sql);
		        	statement.executeUpdate(sql);
		        	
				}
//		  statement.executeUpdate("TRUNCATE vehicles");
		        ResultSet resultSet;
		        resultSet = statement.executeQuery(
		            "select * from vehicles");
		        
		        while(resultSet.next())  
//		        	System.out.println(resultSet.getString(1)+"\t"+resultSet.getString(2)+"\t"+resultSet.getString(3));  
		        resultSet.close();
		        statement.close();
		        connection.close();
		    }
		    catch (Exception exception) {
		        
		    }
		logger.info("loaded to db");
		
	}


}
