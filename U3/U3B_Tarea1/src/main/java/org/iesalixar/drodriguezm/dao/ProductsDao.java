package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.drodriguezm.db.DBConnection;
import org.iesalixar.drodriguezm.model.Product;

public class ProductsDao {
	
	public static List<Product> getAllProducts() {
		Connection conex = DBConnection.getConnection();
		List<Product> products = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM products;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        while (resul.next())      	
	        	products.add(new Product(resul.getString("productCode"),resul.getString("productName"),
	        			resul.getString("productLine"),resul.getString("productScale"),
	        			resul.getString("productVendor"),resul.getString("productDescription"),
	        			resul.getInt("quantityInStock"),resul.getDouble("buyPrice"),
	        			resul.getDouble("MSRP")));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }
		return products;
	}
	
	public static Product getProduct(String productCode) {
		Connection conex = DBConnection.getConnection();
		Product product = null;
		try {
			String busqueda = "SELECT * FROM products WHERE productCode = ?;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,productCode);
	        
	        ResultSet resul = consulta.executeQuery();
	        
	        if (resul.next())      	
	        	product = new Product(resul.getString("productCode"),resul.getString("productName"),
	        			resul.getString("productLine"),resul.getString("productScale"),
	        			resul.getString("productVendor"),resul.getString("productDescription"),
	        			resul.getInt("quantityInStock"),resul.getDouble("buyPrice"),
	        			resul.getDouble("MSRP"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }
		return product;
	}
}
