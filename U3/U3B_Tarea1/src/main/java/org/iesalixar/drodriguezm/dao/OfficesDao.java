package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.drodriguezm.db.DBConnection;
import org.iesalixar.drodriguezm.model.Office;

public class OfficesDao {

	public static List<Office> getAllOffices() {
		Connection conex = DBConnection.getConnection();
		List<Office> offices = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM offices;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
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
	    	DBConnection.close();
	    }
		return offices;
	}
	
	public static List<Office> buscarByCity(String city) {
		Connection conex = DBConnection.getConnection();
		List<Office> offices = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM offices WHERE city=?;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
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
	    	DBConnection.close();
	    }
		return offices;
	}

}
