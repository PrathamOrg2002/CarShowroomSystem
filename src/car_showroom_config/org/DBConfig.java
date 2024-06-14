package car_showroom_config.org;

import java.io.*;
import java.sql.*;
import java.util.Properties;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class DBConfig {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rs;
	private static DBConfig db = null;
	private static CallableStatement cs;
	private static Properties p = new Properties();
	
	// constructer
	private DBConfig() {
		try {
			p.load(DBPathHelper.fin);
			String className = p.getProperty("driver.classname");
			String uName = p.getProperty("db.username");
			String pass = p.getProperty("db.password");
			String url = p.getProperty("db.url");
			Class.forName(className);
			conn = DriverManager.getConnection(url, AESEncry.decrypt(uName), AESEncry.decrypt(pass));
			if (conn != null) {
				System.out.println("Database Connected");
			} else {
				System.out.println("Database not Connected");
			}
		} catch (Exception ex) {
			System.out.println("Error in connection " + ex);
		}
	} // End of constructer

	// public method
	public static DBConfig getDBInstance() {
		if (db == null) {
			synchronized (DBConfig.class) // Singleton Check for multithreaded environment
			{
				if (db == null) {
					db = new DBConfig();
				}
			}
		}
		return db;
	}

	public static Connection getConn() {
		return conn;
	}

	public static PreparedStatement getPstmt() {
		return pstmt;
	}

	public static Statement getStmt() {
		return stmt;
	}

	public static ResultSet getRs() {
		return rs;
	}

	public static DBConfig getDb() {
		return db;
	}
	
	public static Properties getp()
	{
		return p; 
	}
	
	public static CallableStatement getCallStatement()
	{
		return cs;
	}
	
}