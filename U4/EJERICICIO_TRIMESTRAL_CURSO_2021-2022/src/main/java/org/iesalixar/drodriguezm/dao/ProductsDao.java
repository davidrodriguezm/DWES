package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iesalixar.drodriguezm.db.DbPoolConnection;
import org.iesalixar.drodriguezm.model.Product;


public class ProductsDao {
	
	public static List<Product> getAllProducts() {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Product> products = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM products;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
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
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return products;
	}
	
	public static Product getProduct(String productCode) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		Product product = null;
		try {
			String busqueda = "SELECT * FROM products WHERE productCode = ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
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
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return product;
	}
	
	public static List<Product> getProductByProductLine(String productLine) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Product> products = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM products WHERE productLine like ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,productLine);

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
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return products;
	}
	
	public static List<Product> search(String buscar) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		List<Product> products = new ArrayList<>();
		try {
			String busqueda = "SELECT * FROM products WHERE productName like ? OR productLine like ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,"%"+buscar+"%");
			consulta.setString(2,"%"+buscar+"%");
	        
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
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return products;
	}
	
	public static boolean removeProduct(String productCode) {
		boolean borrado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "DELETE FROM products WHERE productCode= ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,productCode);

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
	
	public static boolean createProduct(String productCode, String productName, String productLine, 
			String productScale, String productVendor, String productDescription, int quantityInStock, 
			double buyPrice, double mSRP) {
		
		boolean cambiado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "INSERT INTO products VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,productCode);
			consulta.setString(2,productName);
			consulta.setString(3,productLine);
			consulta.setString(4,productScale);
			consulta.setString(5,productVendor);
			consulta.setString(6,productDescription);
			consulta.setInt(7,quantityInStock);
			consulta.setDouble(8,buyPrice);
			consulta.setDouble(9,mSRP);
				      
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
	
	public static boolean updateProduct(String productCode, String productName, String productLine, 
			String productScale, String productVendor, String productDescription, int quantityInStock, 
			double buyPrice, double mSRP) {
		
		boolean cambiado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "UPDATE products SET productName=?, productLine=?, productScale=?, "
					+ "productVendor=?, productDescription=?, quantityInStock=?, buyPrice=?, "
					+ "mSRP=? WHERE productCode=?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,productName);
			consulta.setString(2,productLine);
			consulta.setString(3,productScale);
			consulta.setString(4,productVendor);
			consulta.setString(5,productDescription);
			consulta.setInt(6,quantityInStock);
			consulta.setDouble(7,buyPrice);
			consulta.setDouble(8,mSRP);
			consulta.setString(9,productCode);
			      
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
