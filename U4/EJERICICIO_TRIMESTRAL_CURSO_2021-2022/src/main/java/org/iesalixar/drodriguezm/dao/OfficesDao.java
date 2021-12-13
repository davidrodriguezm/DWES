package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.iesalixar.drodriguezm.db.DbPoolConnection;
import org.iesalixar.drodriguezm.model.Office;


public class OfficesDao {

	public static List<Office> getAllOffices() {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Office> offices = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM offices;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        while (resul.next())      	
	        	offices.add(new Office(resul.getString("officeCode"),resul.getString("city"),
	        			resul.getString("phone"),resul.getString("addressLine1"),
	        			resul.getString("addressLine2"),resul.getString("state"),
	        			resul.getString("country"),resul.getString("postalCode"),
	        			resul.getString("territory")));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return offices;
		}
	
	public static Office getOffice(String officeCode) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		Office office = null;
		try {
			String busqueda = "SELECT * FROM offices WHERE officeCode = ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,officeCode);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        if (resul.next())      	
	        	office = new Office(resul.getString("officeCode"),resul.getString("city"),
	        			resul.getString("phone"),resul.getString("addressLine1"),
	        			resul.getString("addressLine2"),resul.getString("state"),
	        			resul.getString("country"),resul.getString("postalCode"),
	        			resul.getString("territory"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try { 
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return office;
	}
	
	public static List<Office> getByCity(String city) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Office> offices = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM offices WHERE city=?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,city);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        while (resul.next())      	
	        	offices.add(new Office(resul.getString("officeCode"),resul.getString("city"),
	        			resul.getString("phone"),resul.getString("addressLine1"),
	        			resul.getString("addressLine2"),resul.getString("state"),
	        			resul.getString("country"),resul.getString("postalCode"),
	        			resul.getString("territory")));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try { 
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return offices;
	}
}
