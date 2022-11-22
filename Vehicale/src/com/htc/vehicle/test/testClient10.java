package com.htc.vehicle.test;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFRow.CellIterator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.vehicle.Service.VehicleService;
import com.htc.vehicle.ServiceImpl.VehicleServiceImpl;
import com.htc.vehicle.pojo.Vehicle;

public class testClient10 {
public static void main(String[] args) throws Exception {
	List <Vehicle> vehicles=new ArrayList<>();
	
//	System.out.println(vehicles);
	try {
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
//					if(cell.getCellType()==Cell) {
//						
//					}
//					vehicles.add(new Vehicle(cellValue));
					
					switch (columnIndex) {
	                case 0:
	                	
	                	value=cell.getStringCellValue();
	                	System.out.println(value);
	                	String vehicleNo=value;
	                    v.setVehicleNo(vehicleNo);
	                   
	                    break;
	                case 1:
	                	value=cell.getStringCellValue();
	                   String brandName=value;
	                   System.out.println(value);
	                   v.setBrandName(brandName);
	                   
	                    break;
	                case 2:
	                	value=cell.getStringCellValue();
	                	System.out.println(value);
	                  String color=value;
	                  v.setColor(color);
	                 
	                    break;
	                case 3:
	                	value=cell.getStringCellValue();
	                	System.out.println(value);
	                    String vehicleType=value;
	                    v.setVehicleType(vehicleType);
	                    
	                      break;
	                
	                case 4:
	                     valueNum= (int) cell.getNumericCellValue();
	                     System.out.println(valueNum);
	                    int vehicleCC=valueNum;
	                    v.setVehicalCC(vehicleCC);
	                   
	                      break;
	                case 5:
	                     valueNum=(int) cell.getNumericCellValue();
	                     System.out.println(valueNum);
	                    int price=valueNum;
	                    v.setPrice(price);
	                   
	                      break;
	                
					
				}
				
			}vehicles.add(v);
		}
			
		
		workbook.close();
		
		System.out.println(vehicles);	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	
	
}

}




