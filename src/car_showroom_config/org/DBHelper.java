package car_showroom_config.org;

import java.sql.*;

public class DBHelper {
	protected DBConfig db=DBConfig.getDBInstance();
	protected Connection conn= DBConfig.getConn();
	protected Statement stmt= DBConfig.getStmt();
	protected PreparedStatement pstmt= DBConfig.getPstmt();
	protected ResultSet rs= DBConfig.getRs();
}
