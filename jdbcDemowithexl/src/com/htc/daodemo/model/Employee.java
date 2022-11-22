package com.htc.daodemo.model;

public class Employee {
private int employeeId;
private String employeeName;
private String email;
private String contact;



@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email + ", contact="
			+ contact + "]";
}



public int getEmployeeId() {
	return employeeId;
}



public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}



public String getEmployeeName() {
	return employeeName;
}



public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}



public String getEmail() {
	return email;
}



public void setEmail(String email) {
	this.email = email;
}



public String getContact() {
	return contact;
}



public void setContact(String contact) {
	this.contact = contact;
}



public Employee(int employeeId, String employeeName, String email, String contact) {
	super();
	this.employeeId = employeeId;
	this.employeeName = employeeName;
	this.email = email;
	this.contact = contact;
}



public Employee() {
	super();
	// TODO Auto-generated constructor stub
}



@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + employeeId;
	return result;
}



@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (employeeId != other.employeeId)
		return false;
	return true;
}
}
