package com.htc.vehicle.test;

import java.io.IOException;

import com.htc.vehicle.Dao.VehicleDao;
import com.htc.vehicle.DaoImpl.VehicleDaoImpl;
import com.htc.vehicle.DbUtil.DbUtil;

public class TestClient4 {
public static void main(String[] args) throws SecurityException, IOException {
	DbUtil dbase=new DbUtil();
	VehicleDao Vehs=new VehicleDaoImpl();
//	((VehicleDaoImpl) Vehs).writeExcel();
	System.out.println(((VehicleDaoImpl) Vehs).ReadExcel());
	
//	((VehicleDaoImpl) Vehs).ExcelToDb();
}
}
