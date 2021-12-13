package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.drodriguezm.db.DbPoolConnection;
import org.iesalixar.drodriguezm.model.Employee;

public class EmployeesDao {
	
	public static List<Employee> getAllEmployees() {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Employee> employees = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM employees;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        while (resul.next())      	
	        	employees.add(new Employee(resul.getInt("employeeNumber"),resul.getString("lastName"),
	        			resul.getString("firstName"),resul.getString("extension"),
	        			resul.getString("email"),resul.getString("officeCode"),
	        			resul.getInt("reportsTo"),resul.getString("jobTitle")));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return employees;
		}
	
	public static Employee getOffice(int employeeNumber) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		Employee employee = null;
		try {
			String busqueda = "SELECT * FROM employees WHERE employeeNumber=?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setInt(1,employeeNumber);	        
	        ResultSet resul = consulta.executeQuery();
	        
	        if (resul.next())      	
	        	employee = new Employee(resul.getInt("employeeNumber"),resul.getString("lastName"),
	        			resul.getString("firstName"),resul.getString("extension"),
	        			resul.getString("email"),resul.getString("officeCode"),
	        			resul.getInt("reportsTo"),resul.getString("jobTittle"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try { 
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return employee;
	}
	
	public static List<Employee> getEmployeesByOfficeCode(String officeCode) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Employee> employees = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM employees WHERE officeCode=?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,officeCode);	        
	        ResultSet resul = consulta.executeQuery();
	        
	        while (resul.next())      	
	        	employees.add(new Employee(resul.getInt("employeeNumber"),resul.getString("lastName"),
	        			resul.getString("firstName"),resul.getString("extension"),
	        			resul.getString("email"),resul.getString("officeCode"),
	        			resul.getInt("reportsTo"),resul.getString("jobTitle")));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return employees;
		}
}
