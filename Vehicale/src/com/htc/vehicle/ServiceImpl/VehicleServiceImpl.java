package com.htc.vehicle.ServiceImpl;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.htc.vehicle.Dao.VehicleDao;
import com.htc.vehicle.DaoImpl.VehicleDaoImpl;
import com.htc.vehicle.Exceptions.VehicleAlreadyExists;
import com.htc.vehicle.Exceptions.VehicleNotFound;
import com.htc.vehicle.LogUtil.LogUtil;
import com.htc.vehicle.Service.VehicleService;
import com.htc.vehicle.pojo.Vehicle;

public class VehicleServiceImpl implements VehicleService {
	Logger logger=null;
	
	
	public VehicleServiceImpl() throws SecurityException, IOException {
		
		super();
		logger=LogUtil.getLog(Class.class.getName());
		
	}

	VehicleDao Vehs=new VehicleDaoImpl();

	@Override
	public boolean newVehicle(Vehicle vehicle) {
		
		return Vehs.addVehicle(vehicle);
	}

	@Override
	public boolean deleteVehicle(String vehicleNo)throws VehicleNotFound {
		
		
		return Vehs.removeVehicle(vehicleNo);
	}

	@Override
	public Vehicle updateVehicle(String brandName, String VehicleType, String VehicleNo, int price) {
		// TODO Auto-generated method stub
		return Vehs.modifyVehicle(brandName, VehicleType, VehicleNo, price);
	}

	@Override
	public Optional<Vehicle> fetchVehicle(String vehicleNo) throws VehicleNotFound {
		// TODO Auto-generated method stub
		
		return Vehs.getVehicle(vehicleNo);
		
	}

	@Override
	public List<Vehicle> fetchAllVehicles() {
		
		return Vehs.getAllVehicles();
	}

	
	
}
