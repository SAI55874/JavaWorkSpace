package com.htc.vehicle.Service;

import java.util.List;
import java.util.Optional;

import com.htc.vehicle.Exceptions.VehicleAlreadyExists;
import com.htc.vehicle.Exceptions.VehicleNotFound;
import com.htc.vehicle.pojo.Vehicle;

public interface VehicleService {
	boolean newVehicle(Vehicle vehicle);
	boolean deleteVehicle(String vehicleNo)throws VehicleNotFound;
	Vehicle updateVehicle(String brandName,String VehicleType,String VehicleNo,int price);
	Optional<Vehicle> fetchVehicle(String vehicleNo)throws VehicleNotFound;
	List<Vehicle> fetchAllVehicles();
}
