package car_showroom_config.org;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class DBConfig {
	private static Connection conn;
	private static PreparedStatement pstmt;
	private static Statement stmt;
	private static ResultSet rs;
	private static DBConfig db=null;
	// constructer 
	private DBConfig()
	{
		try
		{
			
			Properties p= new Properties();
			p.load(DBPathHelper.fin);
			String className=p.getProperty("driver.classname");
			String uName=p.getProperty("db.username");
			String pass = p.getProperty("db.password");
			String url=p.getProperty("db.url");
			Class.forName(className);
			conn=DriverManager.getConnection(url,uName,pass);
			if(conn!=null)
			{
				System.out.println("Connection is Estibles with Database");
			}
			else
			{
				System.out.println("Connection is not Estibles with Database");
			}
		}
		catch(Exception ex)
		{
			System.out.println("Error in connection");
		}
		
	}  // End the constructer
	
	
	// public methode 
	public static DBConfig getDBInstance()
	{
		if(db==null)
		{
			db= new DBConfig();
		}
		return db;
	}  //  end method
	
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
}

//public static void main(String[] args) {
//	File f= new File("");
//	String absPath=f.getAbsolutePath();
//	System.out.println(absPath);
//	String nabsPath=absPath.substring(0, absPath.length())+"//db.properties";
//	System.out.println(nabsPath);
//	try {
//		FileInputStream fin= new FileInputStream(nabsPath);
//		Properties p= new Properties();
//		p.load(fin);
//		System.out.println(p.getProperty("db.username"));
//		String driverClassName=p.getProperty("driver.classname");
//		String username=p.getProperty("db.username");
//		String password=p.getProperty("db.password");
//		String url=p.getProperty("db.url");
//		
//		Class.forName(driverClassName);
//		conn=DriverManager.getConnection(url,username,password);
//		if(conn!=null)
//		{
//			System.out.println("DataBase is Connected");
//		}
//		else
//		{
//			System.out.println("DataBase is not Connected");
//		}
//	}catch(Exception ex)
//	{
//		
//	}
//	
//}