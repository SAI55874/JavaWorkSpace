package com.htc.vehicle.test;

import java.io.IOException;

import com.htc.vehicle.Exceptions.VehicleAlreadyExists;
import com.htc.vehicle.Exceptions.VehicleNotFound;
import com.htc.vehicle.Service.VehicleService;
import com.htc.vehicle.ServiceImpl.VehicleServiceImpl;
import com.htc.vehicle.pojo.Vehicle;

public class TestClient2 {
public static void main(String[] args) throws SecurityException, IOException, VehicleNotFound, VehicleAlreadyExists {
	VehicleService vs= new VehicleServiceImpl();
	vs.deleteVehicle("UP_39_PD_3363");
	vs.newVehicle(new Vehicle("AP_26_ED_2121","Pulser","red","Bike",220,200000));
	System.out.println(vs.fetchVehicle("AP_39_PD_2122"));
	System.out.println(vs.fetchVehicle("AP_39_PD_9999"));
	System.out.println(vs.updateVehicle("TataNano","car", "AP_39_PD_9999", 0));
	System.out.println(vs.fetchVehicle("AP_39_PD_9999"));
	System.out.println(vs.fetchAllVehicles());
}
}
