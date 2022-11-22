package com.htc.vehicle.pojo;

import java.util.Objects;

public class Vehicle {
private String VehicleNo;
private String brandName;
private String color;
private String vehicleType;
private int VehicalCC;
private int price;


public Vehicle() {
	super();
	
}


public String getVehicleNo() {
	return VehicleNo;
}


public void setVehicleNo(String vehicleNo) {
	VehicleNo = vehicleNo;
}


public String getBrandName() {
	return brandName;
}


public void setBrandName(String brandName) {
	this.brandName = brandName;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getVehicleType() {
	return vehicleType;
}


public void setVehicleType(String vehicleType) {
	this.vehicleType = vehicleType;
}


public int getVehicalCC() {
	return VehicalCC;
}


public void setVehicalCC(int vehicalCC) {
	VehicalCC = vehicalCC;
}


public int getPrice() {
	return price;
}


public void setPrice(int price) {
	this.price = price;
}


public Vehicle(String vehicleNo, String brandName, String color, String vehicleType, int vehicalCC, int price) {
	super();
	VehicleNo = vehicleNo;
	this.brandName = brandName;
	this.color = color;
	this.vehicleType = vehicleType;
	VehicalCC = vehicalCC;
	this.price = price;
}


@Override
public int hashCode() {
	return Objects.hash(VehicleNo);
}


@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Vehicle other = (Vehicle) obj;
	return Objects.equals(VehicleNo, other.VehicleNo);
}


@Override
public String toString() {
	
	return "Vehicle [VehicleNo=" + VehicleNo + ", brandName=" + brandName + ", color=" + color + ", vehicleType="
			+ vehicleType + ", VehicalCC=" + VehicalCC + ", price=" + price + "]";
}





}
