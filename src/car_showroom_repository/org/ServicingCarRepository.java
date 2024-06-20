package car_showroom_repository.org;

import car_showroom_config.org.DBHelper;

public class ServicingCarRepository extends DBHelper {

	public int getCarIdByNumber(String number) {
		
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("selectIdByCarNumber"));
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

	public boolean getCarById(int id) {
		try
		{
			String selectAllServicingCarModel =properties.getProperty("selectAllServicingCarModel");
			pstmt=conn.prepareStatement(selectAllServicingCarModel);
			pstmt.setInt(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				return true;
			}
			else
			{
				System.out.println("No id matched with database car id");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}
	}

	public boolean changeCarStatusYesById(int carid) {
		try
		{
			pstmt=conn.prepareStatement(properties.getProperty("updateServicingCarModel"));
			pstmt.setInt(1, carid);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Status updated");
				return true;
			}
			else
			{
				System.out.println("Status not updated");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}

	}
	public boolean changeCarStatusNoById(int carid) {
		try
		{
			String updateservicingcarmodelId=properties.getProperty("updateservicingcarmodelId");
			pstmt=conn.prepareStatement(updateservicingcarmodelId);
			pstmt.setInt(1, carid);
			int value=pstmt.executeUpdate();
			if(value>0)
			{
				System.out.println("Status updated");
				return true;
			}
			else
			{
				System.out.println("Status not updated");
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("Error is "+e);
			return false;
		}

	}

}
