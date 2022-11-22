package com.htc.vehicle.test;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.vehicle.pojo.Vehicle;

public class LoadExcel {
public static void main(String[] args) {
	try {
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
		
		ArrayList<Vehicle> list=createData();
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
		FileOutputStream fileOut = new FileOutputStream("VehicleDetails5.xlsx");
		workbook.write(fileOut);
		fileOut.close();
		workbook.close();
		System.out.println("fileloaded");
		
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private static ArrayList<Vehicle> createData() {
	ArrayList<Vehicle> list = new ArrayList();
	list.add(new Vehicle("AP_39_PD_2121","Audi","white","Car",3000,20000000));
	list.add(new Vehicle("TN_39_PD_2123","Benz","black","Car",3500,1000000));
	list.add(new Vehicle("AP_39_PD_3345","MaruthisuZuki","black","Car",3200,500000));
	list.add(new Vehicle("MP_39_PD_6464","Tataindica","black","Car",2400,600000));
	list.add(new Vehicle("AP_39_PD_9999","Hundai","black","Car",4000,700000));
	list.add(new Vehicle("UP_39_PD_3363","Kia","black","Car",4000,1000000));
	list.add(new Vehicle("AP_39_PD_9812","Ashokleyland","black","Lorry",4000,1000000));
	list.add(new Vehicle("AP_39_PD_6363","Kia","black","Car",2500,1000000));
	list.add(new Vehicle("TS_39_PD_8945","Isuzu","black","Car",2000,1000000));
	list.add(new Vehicle("AP_39_PD_7281","benz","black","Car",2000,1000000));
	list.add(new Vehicle("AP_39_PD_7382","RossRoyels","black","Car",6000,1000000));
	list.add(new Vehicle("AP_39_PD_9738","Ferrari","black","Car",8000,1000000));
	list.add(new Vehicle("AP_39_PD_9373","Benz","black","Lorry",8000,1000000));
	list.add(new Vehicle("AP_39_PD_9272","Benz","black","Car",4000,1000000));
	list.add(new Vehicle("AP_39_PD_9929","Mahindra","black","Lorry",4000,1000000));
	list.add(new Vehicle("AP_39_PD_8383","Fz","black","Bike",4000,1000000));
	list.add(new Vehicle("AP_39_PD_7783","Pulser","black","Bike",4000,1000000));
	list.add(new Vehicle("AP_39_PD_2122","Benz","black","Car",4000,1000000));
	list.add(new Vehicle("AP_39_PD_2132","Hero","black","Bike",4000,1000000));
	list.add(new Vehicle("AP_39_PD_7878","Tata","black","Car",4000,1000000));
	list.add(new Vehicle("AP_39_PD_5353","Asholeyland","black","Lorry",4000,1000000));
	list.add(new Vehicle("AP_39_PD_8282","JCB","black","Drozer",4000,1000000));
	
	return list;
}
}
