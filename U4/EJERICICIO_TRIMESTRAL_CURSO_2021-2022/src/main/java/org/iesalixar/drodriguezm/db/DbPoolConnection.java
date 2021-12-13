package org.iesalixar.drodriguezm.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.InitialContext;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DbPoolConnection {
	
	public static Connection getConnectionTomcat() {
		Connection connection = null;
		try {
			connection = ((BasicDataSource) ((new InitialContext())
					.lookup("java:/comp/env/jdbc/classicmodels")))
					.getConnection();				
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;			
	}
	
	public static Connection getConnectionProperties() {
		Connection connection = null;
		try {
			Properties properties = new Properties();
			properties.load(Thread.currentThread().getContextClassLoader()
					.getResourceAsStream("configuration.properties"));
			
			BasicDataSource dataSource = new BasicDataSource();
			String url = properties.getProperty("db.url") + "//" + properties.getProperty("db.host") + ":"
					+ properties.getProperty("db.port") + "/" + properties.getProperty("db.dbname");

			dataSource.setDriverClassName(properties.getProperty("db.classForName"));		
			dataSource.setUsername(properties.getProperty("db.username"));
			dataSource.setPassword(properties.getProperty("db.password"));
			dataSource.setUrl(url);
			dataSource.setMaxTotal(Integer.parseInt(properties.getProperty("db.maxTotal")));
			dataSource.setMaxIdle(Integer.parseInt(properties.getProperty("db.maxIdle")));

			connection = dataSource.getConnection();	
						
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;			
	}
}