package com.htc.daodemo.dao;

import java.util.List;

import com.htc.daodemo.model.Employee;

public interface EmployeeDAO {

	List<Employee> getEmployees();
	boolean addEmployee(Employee employee);
	int addEmployees(List<Employee> employee);
	boolean deleteEmployee(int empid);
	boolean updateEmployee(int empid,String phone);
	String loadDBtoExcel(String excelFilePath);
	List<Employee> unloadDatafromExcel(String excelFilePath);
	
}
