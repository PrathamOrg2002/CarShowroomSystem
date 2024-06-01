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

	public boolean getCarById(int id) {
		try
		{
			pstmt=conn.prepareStatement("select * from servicingcarmodel where id=?");
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
			pstmt=conn.prepareStatement("update servicingcarmodel set carstatus=1 where id=?");
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
			pstmt=conn.prepareStatement("update servicingcarmodel set carstatus=0 where id=?");
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
