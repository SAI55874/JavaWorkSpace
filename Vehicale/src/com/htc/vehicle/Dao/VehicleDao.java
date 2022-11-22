package com.htc.vehicle.Dao;

import com.htc.vehicle.pojo.Vehicle;

import java.util.List;
import java.util.Optional;

import com.htc.vehicle.Exceptions.*;
public interface VehicleDao {
boolean addVehicle(Vehicle vehicle) ;
boolean removeVehicle(String vehicleNo) throws VehicleNotFound;
Vehicle modifyVehicle(String brandName,String VehicleType,String VehicleNo,int price) ;
List<Vehicle> getAllVehicles();
Optional<Vehicle> getVehicle(String vehicleNo) throws VehicleNotFound;
}
