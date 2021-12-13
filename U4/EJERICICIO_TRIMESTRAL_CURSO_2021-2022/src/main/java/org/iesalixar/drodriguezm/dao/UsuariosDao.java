package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.drodriguezm.db.DbPoolConnection;
import org.iesalixar.drodriguezm.misc.PasswordHashGenerator;
import org.iesalixar.drodriguezm.model.Usuario;


public class UsuariosDao {

	public static Usuario getUsuario(String nombre) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		Usuario usuario = null;
		try {
			String busqueda = "SELECT * FROM usuarios WHERE usuario = ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,nombre);
	        
	        ResultSet resultado = consulta.executeQuery();
	        
	        if (resultado.next()) 
	        	usuario = new Usuario(resultado.getString("usuario"),resultado.getString("email"),
	        			resultado.getString("password"),resultado.getString("role"),
		        		resultado.getString("firstName"),resultado.getString("lastName"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return usuario;
	}
	
	public static Usuario getUsuarioByEmail(String email) {
		Connection connec = DbPoolConnection.getConnectionProperties();
		Usuario usuario = null;
		try {
			String busqueda = "SELECT * FROM usuarios WHERE email= ?;";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,email);
	        
	        ResultSet resultado = consulta.executeQuery();
	        
	        if (resultado.next()) 
	        	usuario = new Usuario(resultado.getString("usuario"),resultado.getString("email"),
	        			resultado.getString("password"),resultado.getString("role"),
		        		resultado.getString("firstName"),resultado.getString("lastName"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	try {
	    		connec.close();				
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
		return usuario;
	}
	
	public static Usuario login(String email, String password) {
		Usuario usuario = getUsuarioByEmail(email);
		Usuario usuarioLogin = null;
		
		if(usuario != null && PasswordHashGenerator.checkPassword(password,usuario.getPassword()))
			usuarioLogin = new Usuario(usuario.getNombre(),usuario.getEmail(),usuario.getRole());
		
		return usuarioLogin;
	}
	
	public static boolean createUsuario(String nombre, String email, String password, String role,
			String firstName, String lastName) {
		boolean creado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "INSERT INTO usuarios VALUES(?,?,?,?,?,?);";
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,nombre);
			consulta.setString(2,email);
			consulta.setString(3,password);
			consulta.setString(4,role);
			consulta.setString(5,firstName);
			consulta.setString(6,lastName);

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
	
	public static boolean updatePassword(String password, String nombre) {
		boolean cambiado = false;
		Connection connec = DbPoolConnection.getConnectionProperties();
		try {
			String busqueda = "UPDATE usuarios SET password =? WHERE usuario = ?;";	
			PreparedStatement consulta = connec.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,password);
			consulta.setString(2,nombre);
			
			      
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
