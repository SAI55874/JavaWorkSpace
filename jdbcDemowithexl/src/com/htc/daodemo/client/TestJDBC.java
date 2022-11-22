package com.htc.daodemo.client;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.htc.daodemo.dao.EmployeeDAO;
import com.htc.daodemo.daoImpl.EMployeeDAOImpl;
import com.htc.daodemo.model.Employee;

public class TestJDBC {
	public static void main(String[] args) {

		EmployeeDAO dao = new EMployeeDAOImpl();

		/*
		 * List<Employee> emplist=dao.getEmployees();
		 * 
		 * for (Iterator iterator = emplist.iterator(); iterator.hasNext();) { Employee
		 * employee = (Employee) iterator.next(); System.out.println(employee);
		 * 
		 * }
		 */

		// Employee emp=new Employee(14,"Ria","ria@gmail.com","0987690534");

		/*
		 * if(dao.addEmployee(emp)) { System.out.println("successfully stored in db"); }
		 * else { System.out.println("there is an error"); }
		 */

		/*
		 * if(dao.deleteEmployee(7)) { System.out.println("successfully stored in db");
		 * } else { System.out.println("there is an error"); }
		 */

		/*
		 * if(dao.updateEmployee(6,"988988456")) {
		 * System.out.println("successfully stored in db"); } else {
		 * System.out.println("there is an error"); }
		 */


		/*
		 * List<Employee> employees=new ArrayList<Employee>(); employees.add(new
		 * Employee(26,"Reshma","reshma@gmail.com","0987690534")); employees.add(new
		 * Employee(27,"Ria","ria@gmail.com","0987690534"));
		 * 
		 * 
		 * System.out.println(dao.addEmployees(employees));
		 */

	//dao.loadDBtoExcel("D:\\employeeDetail.xlsx");
		System.out.println(dao.unloadDatafromExcel("D:\\employeeDetail.xlsx"));

	}
}
