package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;

public class ServicingCarRepository extends DBHelper {

	public int getCarIdByNumber(String number) {
		
		try
		{
			pstmt=conn.prepareStatement("select id from ServicingCarModel where carnumber=?;");
			pstmt.setString(1,number);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt(1);
			}
			return 0;
		}
		catch(Exception e)
		{
			System.out.println("Error in finding car id");
			return 0;
		}
		
	}

}
