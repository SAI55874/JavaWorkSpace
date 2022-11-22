package com.htc.daodemo.daoImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.htc.daodemo.LogUtil.LogUtil;
import com.htc.daodemo.dao.EmployeeDAO;
import com.htc.daodemo.dbutil.DBUtil;
import com.htc.daodemo.model.Employee;

public class EMployeeDAOImpl implements EmployeeDAO{
	
Logger logger=null;
Connection con=null;
PreparedStatement pst=null;
CallableStatement cst=null;
ResultSet rs=null;
	
public EMployeeDAOImpl() {
	try {
		logger = LogUtil.getLog(Class.class.getName());
	} catch (SecurityException e1) {
		
		e1.printStackTrace();
	} catch (IOException e1) {
		
		logger.info(e1.getMessage());
	}
}

	
	
	@Override
	public List<Employee> getEmployees() {
		con=DBUtil.getConnection();
		List<Employee> empList=new ArrayList<>();
		
		try {
			//pst=con.prepareStatement("select id,name,email,phone from employee");
			cst=con.prepareCall("{call getEmployees()}");
			rs=cst.executeQuery();
			while(rs.next())
			{
				//empList.add(new Employee(rs.getInt("id"),rs.getString("name"),rs.getString("email"),rs.getString("phone")));
				empList.add(new Employee(rs.getInt("empid"),rs.getString("empname"),rs.getString("mail"),rs.getString("contact")));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return empList;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		con=DBUtil.getConnection();
		boolean flag=false;
		try {
			/*
			 * pst=con.
			 * prepareStatement("insert into employee(id,name,email,phone) values(?,?,?,?)"
			 * ); pst.setInt(1, employee.getEmployeeId());
			 * pst.setString(2,employee.getEmployeeName());
			 * pst.setString(3,employee.getEmail()); pst.setString(4,employee.getContact());
			 */
			//flag=pst.execute();
			
			
			cst=con.prepareCall("{?=call storeEmployee(?,?,?,?)}");
			cst.registerOutParameter(1,java.sql.Types.INTEGER);
			
			cst.setInt(2, employee.getEmployeeId());
			  cst.setString(3,employee.getEmployeeName());
			 cst.setString(4,employee.getEmail());
			 cst.setString(5,employee.getContact());
			
			
			
		cst.execute();
		
		int i=cst.getInt(1);
		System.out.println(i);
			if(i>0)
			{
		flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;
	}

	@Override
	public boolean deleteEmployee(int empid) {
		con=DBUtil.getConnection();
		boolean flag=false;
		try {
			pst=con.prepareStatement("delete from employee where id=?");
			pst.setInt(1, empid);
			int i=pst.executeUpdate();
			if(i>0)
			{
		flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return flag;

}


	@Override
	public boolean updateEmployee(int empid, String phone) {
		con=DBUtil.getConnection();
		
		boolean flag=false;
		try {
			pst=con.prepareStatement("update employee set phone=? where id=?");
			pst.setString(1, phone);
			pst.setInt(2, empid);
			int i=pst.executeUpdate();
			if(i>0)
			{
		flag=true;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return flag;
	}

	@Override
	public int addEmployees(List<Employee> employees) {
		con=DBUtil.getConnection();
		
		int i=0;
		try {
			pst=con.prepareStatement("insert into employee(id,name,email,phone) values(?,?,?,?)");
					 // );
			 //cst=con.prepareCall("{call addEmployee(?,?,?,?}") ;
			//flag=pst.execute();
			for(Employee employee :employees)
			{
			
			
			//cst.registerOutParameter(1,java.sql.Types.INTEGER);
			
			/*cst.setInt(1,employee.getEmployeeId());
			  cst.setString(2,employee.getEmployeeName());
			 cst.setString(3,employee.getEmail());
			 cst.setString(4,employee.getContact());
			 
			 cst.addBatch();*/
				
				
				  pst.setInt(1, employee.getEmployeeId());
				  pst.setString(2,employee.getEmployeeName());
				  pst.setString(3,employee.getEmail()); 
				  pst.setString(4,employee.getContact());
				  
				  pst.addBatch();
				 
				
			
		}
		int[] res=pst.executeBatch();
		
			
			  i=res.length; System.out.println(Arrays.toString(res));
			 
				
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	
	
		
		
		
		
		return i;
	}

	@Override
	public String loadDBtoExcel(String excelFilePath) {
		
		List<Employee> emplist=getEmployees();
	logger.info("retrived data from database");
		//creating workBook
		Workbook workbook = null;
		 
	    if (excelFilePath.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook();
	    } else if (excelFilePath.endsWith("xls")) {
	        workbook = new HSSFWorkbook();
	    } else {
	        throw new IllegalArgumentException("The specified file is not Excel file");
	    }
	    
	    //creating sheet
	    XSSFSheet sheet = (XSSFSheet) workbook.createSheet();
	    
	    
	    //styling cells
	    CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
	    Font font = sheet.getWorkbook().createFont();
	    font.setBold(true);
	    font.setFontHeightInPoints((short) 16);
	    cellStyle.setFont(font);
	 //creating headers
	    Row row = sheet.createRow(0);
	    Cell cellempid = row.createCell(0);
	 
	    cellempid.setCellStyle(cellStyle);
	    cellempid.setCellValue("EmployeeId");
	 
	    Cell cellempName = row.createCell(1);
	    cellempName.setCellStyle(cellStyle);
	    cellempName.setCellValue("EmployeeName");
	 
	    Cell cellemail = row.createCell(2);
	    cellemail.setCellStyle(cellStyle);
	    cellemail.setCellValue("email Id");
	    
	    Cell cellcontact = row.createCell(3);
	    cellcontact.setCellStyle(cellStyle);
	    cellcontact.setCellValue("contact");
	    
	  //creating data cells  
	    int rowCount=1;
	    for (Employee employee : emplist) {
	         row = sheet.createRow(rowCount++);
	        Cell cell = row.createCell(0);
	        cell.setCellValue(employee.getEmployeeId());
	     
	        cell = row.createCell(1);
	        cell.setCellValue(employee.getEmployeeName());
	     
	        cell = row.createCell(2);
	        cell.setCellValue(employee.getEmail());
	        
	        cell = row.createCell(3);
	        cell.setCellValue(employee.getContact());
	    }
	    //writing to the file
	    FileOutputStream outStream=null;
	    try {
			 outStream=new FileOutputStream(excelFilePath);
			workbook.write(outStream);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    finally
	    {
	    	
	    try {
	    	workbook.close();
			outStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	    }
	    
	    
		
		return "successfully written on excel";
	}

	@Override
	public List<Employee> unloadDatafromExcel(String excelFilePath) {
		
		List<Employee> employees=new ArrayList<Employee>();
		 Employee e=new Employee();
	        FileInputStream inputStream=null;
			try {
				inputStream = new FileInputStream(new File(excelFilePath));
			} catch (FileNotFoundException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
		
		  Workbook workbook = null;
		  
		  if (excelFilePath.endsWith("xlsx")) { try {
			workbook = new XSSFWorkbook(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} } else
		  if (excelFilePath.endsWith("xls")) { try {
			workbook = new HSSFWorkbook(inputStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} } else {
		  throw new IllegalArgumentException("The specified file is not Excel file"); }
		 
			
	   logger.info("No of sheets"+workbook.getNumberOfSheets());
	  
	   Sheet firstSheet = workbook.getSheetAt(1);
	    
        Iterator<Row> iterator = firstSheet.iterator();
         
        while (iterator.hasNext()) {
            Row nextRow = iterator.next();
            Iterator<Cell> cellIterator = nextRow.cellIterator();
             
            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
               //System.out.println(cell.toString());
                int columnIndex=cell.getColumnIndex();
                 
                switch (columnIndex) {
                case 0:
                	double d=(double)getCellValue(cell);
                	int empid=(int)d;
                   e.setEmployeeId(empid);
                    break;
                case 1:
                    e.setEmployeeName((String) getCellValue(cell));
                    break;
                case 2:
                  e.setEmail((String) getCellValue(cell));
                    break;
                case 3:
                    e.setContact((String) getCellValue(cell));
                      break;
               }
     
     
            }
            employees.add(e);
            logger.info("read file");
        }
         
        try {
			workbook.close();
			inputStream.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
	    
		return employees;
	}
	
	
	
	
	private Object getCellValue(Cell cell) 
	{
		
		
	    switch (cell.getCellType()) {
	    case STRING:
	        return cell.getStringCellValue();
	 
	    case BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
}
