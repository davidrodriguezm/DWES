package org.iesalixar.drodriguezm.db;

public class DBConfig {	
	private String host;
	private String port;
	private String URL;
	private String dbName;
	private String dbUser;
	private String dbPassword;
	private String classForName;
	
	
	public DBConfig() {}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getURL() {
		return URL;
	}

	public void setURL(String uRL) {
		URL = uRL;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName= dbName;
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getClassForName() {
		return classForName;
	}

	public void setClassForName(String classForName) {
		this.classForName = classForName;
	}

	public String getFullUrl() {
		return URL + "//" + host + ":" + port + "/" + dbName;
	}
	
	public String getConnectionString() {
		return getFullUrl() + "?user=" + dbUser + "&password=" + dbPassword
				+ "&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}

	@Override
	public String toString() {
		return "DBConfig [host=" + host + ", port=" + port + ", URL=" + URL + ", dbName=" + dbName + ", dbUser=" + dbUser
				+ ", dbPassword=" + dbPassword + ", classForName=" + classForName + "]";
	}
}