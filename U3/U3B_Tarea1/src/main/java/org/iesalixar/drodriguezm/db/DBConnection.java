package org.iesalixar.drodriguezm.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;


public class DBConnection {
	private static Connection connection = null;
	private static DBConfig configDB = null;

	public static Connection getConnection() {
		try {
			if(connection == null || connection.isClosed()) {
				
				if(setConfiguration()) {					
					Class.forName(configDB.getClassForName());
					
					connection = DriverManager.getConnection(configDB.getConnectionString());
					
				} else System.out.println("No se ha extraido los datos de conexión");
			}
		} catch (Exception e) {			
			System.out.println(e.getMessage());
		}		
		return connection;					
	}
	
	public static void close() {
        try {
			if (connection != null || !connection.isClosed()) connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean setConfiguration() {
		boolean extraido = false;
		try {		
			Properties prop = new Properties();
			InputStream is = DBConnection.class.getClassLoader().getResourceAsStream("configurationDB.properties");
			prop.load(is);
			configDB = new DBConfig();
			
			for (Enumeration e = prop.keys(); e.hasMoreElements();) {	
				String key = (String) e.nextElement();
				
				switch (key) {
					case "host":
						configDB.setHost(prop.getProperty(key));
						break;
					case "port":
						configDB.setPort(prop.getProperty(key));
						break;
					case "URL":
						configDB.setURL(prop.getProperty(key));
						break;
					case "name":
						configDB.setDbName(prop.getProperty(key));
						break;
					case "userName":
						configDB.setDbUser(prop.getProperty(key));
						break;
					case "password":
						configDB.setDbPassword(prop.getProperty(key));
						break;
					case "classForName":
						configDB.setClassForName(prop.getProperty(key));
						break;	
				}			
			}
			extraido = true;
		} catch (Exception e) {
			System.out.println(e.getMessage());			
		}
		return extraido;
	}
}
