package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import misc.DBConfig;

public class DBConnection {

	private static Connection connection = null;
	
	public static Connection getConnecttion() {
		try {
			if(connection == null || connection.isClosed()) {		        
				Class.forName(DBConfig.getClassForName());
				connection = DriverManager.getConnection(
						DBConfig.getFullUrl(),
						DBConfig.getDbUser(),
						DBConfig.getDbPassword());
			} 
		} catch (Exception e) {			
			e.printStackTrace();
		}		
		return connection;					
	}
	
	public static void close() {
        if ( connection != null ) {
        	connection = null;
        }

	}
}
