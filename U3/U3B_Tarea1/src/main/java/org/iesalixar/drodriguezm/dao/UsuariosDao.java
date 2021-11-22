package org.iesalixar.drodriguezm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iesalixar.drodriguezm.db.DBConnection;
import org.iesalixar.drodriguezm.misc.PasswordHashGenerator;
import org.iesalixar.drodriguezm.model.Usuario;

public class UsuariosDao {

	public static Usuario getUsuario(String nombre) {
		Connection conex = DBConnection.getConnection();
		Usuario usuario = null;
		try {
			String busqueda = "SELECT * FROM usuarios WHERE nombre = ?;";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
	        consulta.setQueryTimeout(30);
	        
	        consulta.setString(1,nombre);
	        
	        ResultSet resultado = consulta.executeQuery();
	        
	        if (resultado.next()) 
	        	usuario = new Usuario(resultado.getString("nombre"),resultado.getString("email"),
	        		resultado.getString("rol"),resultado.getString("password"),
	        		resultado.getString("firstName"),resultado.getString("LastName"));
	        
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }
		return usuario;
	}
	
	public static Usuario login(String nombre, String password) {
		Usuario usuario = getUsuario(nombre);
		Usuario usuarioLogin = null;
		
		if(usuario != null && PasswordHashGenerator.checkPassword(password,usuario.getPassword()))
			usuarioLogin = new Usuario(usuario.getNombre(),usuario.getEmail(),usuario.getRol(),
					usuario.getFirstName(),usuario.getLastName());
		
		return usuarioLogin;
	}
	
	public static boolean createUsuario(String nombre, String email, String rol, String password) {
		boolean creado = false;
		Connection conex = DBConnection.getConnection();
		try {
			String busqueda = "INSERT INTO usuarios VALUES(?,?,?,?);";
			PreparedStatement consulta = conex.prepareStatement(busqueda);
			consulta.setQueryTimeout(30);
			
			consulta.setString(1,nombre);
			consulta.setString(2,email);
			consulta.setString(3,rol);
			consulta.setString(4,password);

        	creado = consulta.executeUpdate() != 0 ? true:false;
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	    	DBConnection.close();
	    }	
		return creado;
	}
}
