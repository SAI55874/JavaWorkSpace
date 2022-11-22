package com.htc.vehicle.test;

import java.io.FileOutputStream;
import java.io.IOException;
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

import com.htc.vehicle.Dao.VehicleDao;
import com.htc.vehicle.DaoImpl.VehicleDaoImpl;
import com.htc.vehicle.Service.VehicleService;
import com.htc.vehicle.ServiceImpl.VehicleServiceImpl;
import com.htc.vehicle.pojo.Vehicle;

public class TestClient1 {
public static void main(String[] args) throws SecurityException, IOException {
	VehicleService vs= new VehicleServiceImpl();
	System.out.println(vs.updateVehicle("TataNano","car", "AP_39_PD_9999", 0));
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
	
	List<Vehicle> list=vs.fetchAllVehicles();
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
	FileOutputStream fileOut = new FileOutputStream("VehicleDetails22.xlsx");
	workbook.write(fileOut);
	fileOut.close();
	workbook.close();
	System.out.println("fileloaded");
	
} catch (Exception e) {
	e.printStackTrace();
}
}
}
