package car_showroom_config.org;

import java.io.File;
import java.io.FileInputStream;
 
public class DBPathHelper {
	public static FileInputStream fin=null;
	public static File f=new File(".");
	public static String nabsPath=(f.getAbsolutePath().substring(0, f.getAbsolutePath().length()-1)+"src\\");
	
	static {
		String path=nabsPath+"db.properties";
		try
		{
			fin= new FileInputStream(path);
		}
		catch(Exception ex)
		{
			System.out.println("Error  !!!!!!");
		}
	}
	
	
	
}
