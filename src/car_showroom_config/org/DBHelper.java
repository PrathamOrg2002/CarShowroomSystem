package car_showroom_config.org;

import java.sql.*;
import java.util.Properties;

public class DBHelper {
	protected DBConfig db = DBConfig.getDBInstance();
	protected Connection conn = DBConfig.getConn();
	protected Statement stmt = DBConfig.getStmt();
	protected PreparedStatement pstmt = DBConfig.getPstmt();
	protected ResultSet rs = DBConfig.getRs();
	protected Properties properties = DBConfig.getp();
	protected CallableStatement cs=DBConfig.getCallStatement();
	protected PasswordEncr passwordencr=new PasswordEncr();
	protected AESEncry AESEncr=new AESEncry();
}
