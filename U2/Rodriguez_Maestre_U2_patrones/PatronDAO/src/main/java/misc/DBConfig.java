package misc;

public class DBConfig {	
	private static String host = "localhost";
	private static String port = "3326";
	private static String URL = "jdbc:mariadb:";
	private static String db = "classicmodels";
	private static String dbUser = "root";
	private static String dbPassword = "root";
	private static String classForName = "org.mariadb.jdbc.Driver";
	
	public static String getHost() {
		return host;
	}
	
	public static String getPort() {
		return port;
	}
	
	public static String getURL() {
		return URL;
	}

	public static String getClassForName() {
		return classForName;
	}

	public static String getDb() {
		return db;
	}

	public static String getDbUser() {
		return dbUser;
	}

	public static String getDbPassword() {
		return dbPassword;
	}
	
	public static String getFullUrl() {
		return URL + "//" + host + ":" + port + "/" + db;
	}
	
}
