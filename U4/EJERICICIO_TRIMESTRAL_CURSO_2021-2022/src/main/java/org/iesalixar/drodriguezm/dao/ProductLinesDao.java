package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.drodriguezm.db.DbPoolConnection;
import org.iesalixar.drodriguezm.model.ProductLines;


public class ProductLinesDao {

	public static List<ProductLines> getAllProductLines() {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<ProductLines> productLines = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM productlines;";
			PreparedStatement consultas = connec.prepareStatement(busqueda);
	        consultas.setQueryTimeout(30);
	        
	        ResultSet resultado = consultas.executeQuery();
	        
	        while (resultado.next()) {
	        	
	        	productLines.add(new ProductLines(resultado.getString("productLine"),
	        			resultado.getString("textDescription"),resultado.getString("htmlDescription")));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return productLines;
	}
	
	public static ProductLines getProductLine(String productLine) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		ProductLines product = null;
		try {
			String busqueda = "SELECT * FROM productlines WHERE productLine = ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,productLine);
	        
	        ResultSet resultado = consulta.executeQuery();
	        
	        if (resultado.next()) product = new ProductLines(
	        		resultado.getString("productLine"),resultado.getString("textDescription"),
	        		resultado.getString("htmlDescription"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return product;
	}
	
	public static boolean createProductLines(String productLine, String textDescription, String htmlDescription) {
		boolean creado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "INSERT INTO productlines VALUES(?,?,?,null);";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,productLine);
			consulta.setString(2,textDescription);
			consulta.setString(3,htmlDescription);

        	creado = consulta.executeUpdate() != 0 ? true:false;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }	
		return creado;
	}
	
	public static boolean removeProductLines(String productLine) {
		boolean borrado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "DELETE FROM productlines WHERE productLine = ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,productLine);

	        borrado = consulta.executeUpdate() != 0 ? true:false;      
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }	
		return borrado;
	}
	
	public static boolean updateProductLines(String productLine, String textDescription, String htmlDescription) {
		boolean cambiado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "UPDATE productlines SET textDescription =?, htmlDescription =?  WHERE productLine = ?;";	
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,textDescription);
			consulta.setString(2,htmlDescription);
			consulta.setString(3,productLine);
			      
	        cambiado = consulta.executeUpdate() != 0 ? true:false;       
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }	
		return cambiado;
	}
}
